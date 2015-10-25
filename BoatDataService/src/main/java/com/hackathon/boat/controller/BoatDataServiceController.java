package com.hackathon.boat.controller;

import com.boat.dataservice.datatype.*;
import com.boat.dataservice.datatype.Customer;
import com.boat.dataservice.datatype.CustomerOnboarding;
import com.boat.dataservice.datatype.Device;
import com.boat.dataservice.datatype.Payment;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackathon.boat.data.CatalogEntity;
import com.hackathon.boat.data.CustomerEntity;
import com.hackathon.boat.data.DeviceEntity;
import com.hackathon.boat.data.ItemEntity;
import com.hackathon.boat.data.TransactionEntity;
import com.hackathon.boat.repository.CatalogRepository;
import com.hackathon.boat.repository.CustomerRepository;
import com.hackathon.boat.repository.DeviceRepository;
import com.hackathon.boat.repository.ItemRepository;
import com.hackathon.boat.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.boat.dataservice.datatype.MerchantOnboarding;
import com.braintreegateway.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackathon.boat.data.MerchantEntity;
import com.hackathon.boat.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by srirkumar on 10/24/2015.
 */
@RestController
public class BoatDataServiceController {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private DeviceRepository deviceRepository;

    /**
     * Merchant Repository
     */
    @Autowired
    private MerchantRepository merchantRepository;


    @Autowired
    private CatalogRepository catalogRepository;
    /**
     * Item Repository
     */
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    /**
     * Master Merchant Id
     */
    private static final String MASTER_MERCHANT = "boatpaymentsolutions";

    /**
     * BrainTree Gateway
     */
    private static final BraintreeGateway gateway = new BraintreeGateway(Environment.SANDBOX, "5zhpcmf7vrg95mzb", "2krv8s7cnc56mxxb", "ccedcb5bb380228cc688c8baa2d8cc44");

    /**
     * Onboard Customer
     * @param customerOnboardingRequest
     * @return
     */
    @RequestMapping(value = "boat/onboarding/customer", produces = "application/json", method = RequestMethod.POST)
    @ResponseBody
    public String createCustomer(@RequestBody String customerOnboardingRequest) {
        String customerResponse = null;
        try {
            System.out.println(customerOnboardingRequest);
            CustomerOnboarding customerOnboarding = objectMapper.readValue(customerOnboardingRequest, CustomerOnboarding.class);
            CustomerEntity customerEntity = populateCustomerEntity(customerOnboarding);
            DeviceEntity deviceEntity = populateDeviceEntity(customerOnboarding);
            customerRepository.save(customerEntity);
            deviceRepository.save(deviceEntity);
            customerOnboarding.getCustomer().setCustomerId(customerEntity.getCustomerId().toString());
            customerOnboarding.getDevice().setDeviceId(String.valueOf(deviceEntity.getDeviceId()));
            customerResponse = objectMapper.writeValueAsString(customerOnboarding);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customerResponse;
    }
    @RequestMapping(value = "boat/customer/macid/{macId}")
    @ResponseBody
    public String getCustomerByMacId(@PathVariable String macId) {
        String customerResponse = null;
        DeviceEntity deviceEntity = deviceRepository.findByMacId(macId);
        CustomerEntity customerEntity = customerRepository.findByBtCustomerId(deviceEntity.getBtCustomerId());
        Device device = populateDeviceJson(deviceEntity);
        Customer customer = populateCustomerJson(customerEntity);
        CustomerOnboarding customerOnboarding = new CustomerOnboarding();
        customerOnboarding.setCustomer(customer);
        customerOnboarding.setDevice(device);
        try {
            customerResponse = objectMapper.writeValueAsString(customerOnboarding);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return customerResponse;
    }

    @RequestMapping(value = "boat/customer/delete")
    @ResponseBody
    public String deleteCustomer() {
        customerRepository.deleteAll();
        deviceRepository.deleteAll();
        return "";
    }

    /**
     * populate customer JSON
     * @param customerEntity
     * @return
     */
    private Customer populateCustomerJson(CustomerEntity customerEntity) {
        Customer customer = new Customer();
        customer.setCustomerId(String.valueOf(customerEntity.getCustomerId()));
        customer.setBtCustomerId(customerEntity.getBtCustomerId());
        customer.setPaymentMethodToken(customerEntity.getPaymentMethodToken());
        return customer;
    }

    private Device populateDeviceJson(DeviceEntity deviceEntity) {
        Device device = new Device();
        device.setDeviceId(String.valueOf(deviceEntity.getDeviceId()));
        device.setMacId(deviceEntity.getMacId());
        device.setBtCustomerId(deviceEntity.getBtCustomerId());
        device.setItemId(String.valueOf(deviceEntity.getItemId()));
        device.setQuantity(String.valueOf(deviceEntity.getQuantity()));
        return device;
    }

    /**
     * Populate Device from JSON
     * @param customerOnboarding
     * @return
     */
    private DeviceEntity populateDeviceEntity(CustomerOnboarding customerOnboarding) {
        DeviceEntity deviceEntity = new DeviceEntity();
        deviceEntity.setBtCustomerId(customerOnboarding.getCustomer().getBtCustomerId());
        deviceEntity.setQuantity(Long.valueOf(customerOnboarding.getDevice().getQuantity()));
        deviceEntity.setItemId(Long.valueOf(customerOnboarding.getDevice().getItemId()));
        deviceEntity.setMacId(customerOnboarding.getDevice().getMacId());
        return deviceEntity;
    }

    /**
     * Populate Customer
     * @param customerOnboarding
     * @return
     */
    private CustomerEntity populateCustomerEntity(CustomerOnboarding customerOnboarding) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setBtCustomerId(customerOnboarding.getCustomer().getBtCustomerId());
        customerEntity.setPaymentMethodToken(customerOnboarding.getCustomer().getPaymentMethodToken());
        return customerEntity;

    }

    /**
     * This method calls the Braintree API for subMerchant Onboarding and then save the response to database
     * @param request Merchant Onboarding Request
     * @return Merchant Onboarding Response
     */
    @RequestMapping(value = "boat/onboarding/merchant", produces = "application/json", method = RequestMethod.POST)
    @ResponseBody
    public String merchantOnboardingService(@RequestBody String request) {
        ObjectMapper objectMapper = new ObjectMapper();
        String merchantOnboardingResponseJSON = null;

        try {
            MerchantOnboarding merchantOnboardingRequest = objectMapper.readValue(request, MerchantOnboarding.class);
            Result<MerchantAccount> result = createMerchantOnBrainTree(merchantOnboardingRequest);
            if(result != null) {
                MerchantEntity merchantEntity = new MerchantEntity();
                merchantEntity.setBusinessName(merchantOnboardingRequest.getBusiness().getLegalName());
                merchantEntity.setSubMerchantId(result.getTarget().getId());
                merchantRepository.save(merchantEntity);
                merchantOnboardingRequest.setId(String.valueOf(result.getTarget().getId()));
            }
            merchantOnboardingResponseJSON = objectMapper.writeValueAsString(merchantOnboardingRequest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return merchantOnboardingResponseJSON;
    }

    /**
     * This method creates sub merchant on braintree
     * @param merchantOnboardingRequest MerchantOnboarding Request
     * @return MerchantAccount
     */
    private Result<MerchantAccount> createMerchantOnBrainTree(MerchantOnboarding merchantOnboardingRequest) {
        MerchantAccountRequest merchantAccountRequest = new MerchantAccountRequest()
                .individual()
                    .firstName(merchantOnboardingRequest.getIndividual().getFirstName())
                    .lastName(merchantOnboardingRequest.getIndividual().getLastName())
                    .email(merchantOnboardingRequest.getIndividual().getEmail())
                    .phone(merchantOnboardingRequest.getIndividual().getPhoneNumber())
                    .dateOfBirth(merchantOnboardingRequest.getIndividual().getDateOfBirth())
                    .ssn(merchantOnboardingRequest.getIndividual().getSsn())
                    .address()
                        .streetAddress(merchantOnboardingRequest.getIndividual().getStreetAddress())
                        .locality(merchantOnboardingRequest.getIndividual().getLocality())
                        .region(merchantOnboardingRequest.getIndividual().getRegion())
                        .postalCode(merchantOnboardingRequest.getIndividual().getPostalCode())
                    .done()
                .done()
                .business()
                    .legalName(merchantOnboardingRequest.getBusiness().getLegalName())
                    .dbaName(merchantOnboardingRequest.getBusiness().getDbaName())
                    .taxId(merchantOnboardingRequest.getBusiness().getTaxId())
                    .address()
                        .streetAddress(merchantOnboardingRequest.getBusiness().getStreetAddress())
                        .locality(merchantOnboardingRequest.getBusiness().getLocality())
                        .region(merchantOnboardingRequest.getBusiness().getRegion())
                        .postalCode(merchantOnboardingRequest.getBusiness().getPostalCode())
                    .done()
                .done()
                .funding()
                    .descriptor(merchantOnboardingRequest.getFunding().getDescriptor())
                    .destination(MerchantAccount.FundingDestination.valueOf(merchantOnboardingRequest.getFunding().getDestination().name()))
                    .email(merchantOnboardingRequest.getFunding().getEmail())
                    .mobilePhone(merchantOnboardingRequest.getFunding().getMobilePhone())
                    .accountNumber(merchantOnboardingRequest.getFunding().getAccountNumber())
                    .routingNumber(merchantOnboardingRequest.getFunding().getRoutingNumber())
                .done()
                .tosAccepted(true)
                .masterMerchantAccountId("boatpaymentsolutions ")
                .id("");
        return gateway.merchantAccount().create(merchantAccountRequest);
    }

    /**
     * Return catalog by item upc
     */
    @RequestMapping(value = "boat/catalog/{itemUpc}", produces = "application/json", method = RequestMethod.GET)
    @ResponseBody
    public String getItemCatalog(@PathVariable String itemUpc) {
        ObjectMapper objectMapper = new ObjectMapper();
        String itemCatalogJSON = null;
        try {
            List<CatalogEntity> catalogEntityList = catalogRepository.findByItemUpc(itemUpc);
            List<Catalog> catalogList = new ArrayList<Catalog>();
            for (CatalogEntity catalogEntity : catalogEntityList) {
                Catalog catalog = new Catalog();
                catalog.setSubMerchantId(String.valueOf(catalogEntity.getSubMerchantId()));
                catalog.setItemUpc(catalogEntity.getItemUpc());
                catalog.setAvailability(catalogEntity.getAvailability());
                catalog.setPrice(String.valueOf(catalogEntity.getPrice()));
                catalog.setQuantity(String.valueOf(catalogEntity.getQuantity()));
                catalogList.add(catalog);
            }
            itemCatalogJSON = objectMapper.writeValueAsString(catalogList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return itemCatalogJSON;
    }

    /**
     * Return item details
     */
    @RequestMapping(value = "boat/items", produces = "application/json", method = RequestMethod.GET)
    @ResponseBody
    public ItemList getItemList() {
        ItemList items = new ItemList();
        List<ItemEntity> itemEntityList = (List<ItemEntity>) itemRepository.findAll();
        List<Item> itemList = new ArrayList<Item>();

        for (ItemEntity itemEntity : itemEntityList) {
            Item item = new Item();
            item.setItemId(String.valueOf(itemEntity.getItemId()));
            item.setItemName(itemEntity.getItemName());
            item.setItemUpc(itemEntity.getItemUpc());
            item.setItemDesc(itemEntity.getItemDesc());
            itemList.add(item);
        }
        items.setItemList(itemList);

        return items;
    }

    /**
     * Return item details by item id
     */
    @RequestMapping(value = "boat/item/{itemId}", produces = "application/json", method = RequestMethod.GET)
    @ResponseBody
    public Item getItemDetails(@PathVariable String itemId) {
        ItemEntity itemEntity = itemRepository.findOne(Long.valueOf(itemId));
        Item item = new Item();
        item.setItemId(String.valueOf(itemEntity.getItemId()));
        item.setItemName(itemEntity.getItemName());
        item.setItemUpc(itemEntity.getItemUpc());
        item.setItemDesc(itemEntity.getItemDesc());
        return item;
    }

    /**
     * make payment
     */
    @RequestMapping(value = "merchant/payment", produces = "application/json", method = RequestMethod.POST)
    @ResponseBody
    public String makePayment(@RequestBody String paymentRequest) {
        String paymentResponseJSON = null;
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(paymentRequest);
        try {
            Payment payment = objectMapper.readValue(paymentRequest, Payment.class);
            Result<PaymentMethodNonce> paymentMethodNonceResult = gateway.paymentMethodNonce().create(payment.getPaymentMethodToken());
            TransactionRequest transactionRequest = new TransactionRequest();
            transactionRequest
                    .amount(new BigDecimal(payment.getAmount()))
                    .serviceFeeAmount(new BigDecimal(payment.getServiceFee()))
                    .merchantAccountId(payment.getSubMerchantId())
                    .paymentMethodNonce(paymentMethodNonceResult.getTarget().getNonce()).options().submitForSettlement(true).done();
            Result<com.braintreegateway.Transaction> paymentTransaction = gateway.transaction().sale(transactionRequest);

            if (paymentTransaction != null && paymentTransaction.getErrors() != null) {
                List<ValidationError> allValidationErrors = paymentTransaction.getErrors().getAllValidationErrors();
                payment.setResponseDescription(appendValidationErrors(allValidationErrors));
            } else {
                payment.setPaymentId(paymentTransaction.getTarget().getId());
                payment.setResponseAuthorizationCode(paymentTransaction.getTarget().getProcessorAuthorizationCode());
            }
            paymentResponseJSON = objectMapper.writeValueAsString(payment);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return paymentResponseJSON;
    }

    public String appendValidationErrors(List<ValidationError> allValidationErrors) {
        StringBuffer sb = new StringBuffer();
        for (ValidationError validationError:allValidationErrors) {
            sb.append(validationError.getMessage()).append("\n");
        }
        return sb.toString();
    }
    @RequestMapping(value="boat/transaction/create", produces = "application/json", method=RequestMethod.POST)
    public void  saveTransaction(@RequestBody String transactionInfoRequest) {
        System.out.println(transactionInfoRequest);
        try {
            TransactionInfo transactionInfo = objectMapper.readValue(transactionInfoRequest, TransactionInfo.class);
            TransactionEntity transactionEntity = populateTransactionEntity(transactionInfo);
            transactionRepository.save(transactionEntity);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private TransactionEntity populateTransactionEntity(TransactionInfo transactionInfo) {
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setBtCustomerId(transactionInfo.getBtCustomerId());
        transactionEntity.setAmount(Double.valueOf(transactionInfo.getAmount()));
        transactionEntity.setItemUpc(transactionInfo.getItemUpc());
        transactionEntity.setSessionId(transactionInfo.getSessionId());
        transactionEntity.setTransactionId(transactionInfo.getTransactionId());
        transactionEntity.setStatus(transactionInfo.getStatus().toString());
        transactionEntity.setTransactionType(transactionInfo.getTransactionType().toString());
        transactionEntity.setSubMerchantId(transactionInfo.getSubMerchantId());
        return transactionEntity;
    }
}

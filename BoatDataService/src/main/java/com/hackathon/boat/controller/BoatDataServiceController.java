package com.hackathon.boat.controller;

import com.boat.dataservice.datatype.Customer;
import com.boat.dataservice.datatype.CustomerOnboarding;
import com.boat.dataservice.datatype.Device;
import com.boat.dataservice.datatype.Payment;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackathon.boat.data.CustomerEntity;
import com.hackathon.boat.data.DeviceEntity;
import com.hackathon.boat.repository.CustomerRepository;
import com.hackathon.boat.repository.DeviceRepository;
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
     * Onboard Customer
     * @param customerOnboardingRequest
     * @return
     */
    @RequestMapping(value = "boat/onboarding/customer", produces = "application/json", method = RequestMethod.POST)
    @ResponseBody
    public String createCustomer(@RequestBody String customerOnboardingRequest) {
        String customerResponse = null;
        try {
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
        deviceEntity.setBtCustomerId(customerOnboarding.getDevice().getBtCustomerId());
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
     * Merchant Repository
     */
    @Autowired
    private MerchantRepository merchantRepository;

    /**
     * BrainTree Gateway
     */
    private static final BraintreeGateway gateway = new BraintreeGateway(Environment.SANDBOX, "3gjxkqn9j4gvkwv8",
            "cbx62tfstsdnjr45",
            "7e4a4983f78893d6cd49db5aa0763b8a");

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
     * make payment
     */
    @RequestMapping(value = "merchant/payment", produces = "application/json", method = RequestMethod.POST)
    @ResponseBody
    public String makePayment(@RequestBody String paymentRequest) {
        String paymentResponseJSON = null;
        ObjectMapper objectMapper = new ObjectMapper();
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
}

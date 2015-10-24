package com.hackathon.boat.controller;

import com.boat.dataservice.datatype.MerchantOnboarding;
import com.braintreegateway.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackathon.boat.data.MerchantEntity;
import com.hackathon.boat.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * Created by srirkumar on 10/24/2015.
 */
@RestController
public class BoatDataServiceController {

    /**
     * Merchant Repository
     */
    @Autowired
    private MerchantRepository merchantRepository;

    /**
     * BrainTree Gateway
     */
    private static final BraintreeGateway gateway = new BraintreeGateway(Environment.SANDBOX, "j7qppkys6zg4qqdr", "dwkmcjgk7xwt6trz", "f5500775a53383cef86a16c8c092f566");

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
                merchantEntity.setBusinessName(result.getTarget().getBusinessDetails().getLegalName());
                merchantEntity.setSubMerchantId(result.getTarget().getId());
                merchantRepository.save(merchantEntity);
            }
            merchantOnboardingResponseJSON = objectMapper.writeValueAsString(result);
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
                .destination(MerchantAccount.FundingDestination.valueOf(merchantOnboardingRequest.getFunding().getDestination().toString()))
                .email(merchantOnboardingRequest.getFunding().getEmail())
                .mobilePhone(merchantOnboardingRequest.getFunding().getMobilePhone())
                .accountNumber(merchantOnboardingRequest.getFunding().getAccountNumber())
                .routingNumber(merchantOnboardingRequest.getFunding().getRoutingNumber())
                .done()
                .tosAccepted(true)
                .masterMerchantAccountId("pappustore")
                .id("Store_1");
        return gateway.merchantAccount().create(merchantAccountRequest);
    }
}

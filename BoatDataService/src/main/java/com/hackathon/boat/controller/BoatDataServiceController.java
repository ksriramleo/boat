package com.hackathon.boat.controller;

import com.boat.dataservice.datatype.Customer;
import com.boat.dataservice.datatype.CustomerOnboarding;
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

import java.io.IOException;

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
            customerOnboarding.getCustomer().setCustomerId(Double.valueOf(customerEntity.getCustomerId()));
            customerOnboarding.getDevice().setDeviceId(String.valueOf(deviceEntity.getDeviceId()));
            customerResponse = objectMapper.writeValueAsString(customerOnboarding);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customerResponse;
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

}

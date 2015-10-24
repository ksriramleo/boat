
package com.boat.dataservice.datatype;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/**
 * customer onboarding
 * <p>
 * customer onboarding
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "customer",
    "device"
})
public class CustomerOnboarding {

    /**
     * Customer details
     * 
     */
    @JsonProperty("customer")
    private Customer customer;
    /**
     * device details
     * 
     */
    @JsonProperty("device")
    private Device device;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * Customer details
     * 
     * @return
     *     The customer
     */
    @JsonProperty("customer")
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Customer details
     * 
     * @param customer
     *     The customer
     */
    @JsonProperty("customer")
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public CustomerOnboarding withCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    /**
     * device details
     * 
     * @return
     *     The device
     */
    @JsonProperty("device")
    public Device getDevice() {
        return device;
    }

    /**
     * device details
     * 
     * @param device
     *     The device
     */
    @JsonProperty("device")
    public void setDevice(Device device) {
        this.device = device;
    }

    public CustomerOnboarding withDevice(Device device) {
        this.device = device;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public CustomerOnboarding withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(customer).append(device).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CustomerOnboarding) == false) {
            return false;
        }
        CustomerOnboarding rhs = ((CustomerOnboarding) other);
        return new EqualsBuilder().append(customer, rhs.customer).append(device, rhs.device).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}

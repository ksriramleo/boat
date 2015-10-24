
package com.boat.dataservice.datatype;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "descriptor",
    "destination",
    "email",
    "mobile_phone",
    "account_number",
    "routing_number"
})
public class Funding {

    /**
     * This field is optional. This field sets the description that will appear on the sub-merchant's deposits from Braintree.
     * 
     */
    @JsonProperty("descriptor")
    private String descriptor;
    /**
     * Funding destination is required, and the value can be email, mobile phone, or bank
     * (Required)
     * 
     */
    @JsonProperty("destination")
    private Funding.Destination destination;
    /**
     * Email address. Required if funding destination is set to email
     * 
     */
    @JsonProperty("email")
    private String email;
    /**
     * Mobile Phone. Required if funding destination is set to Mobile
     * 
     */
    @JsonProperty("mobile_phone")
    private String mobilePhone;
    /**
     * Required if fundingDestination is set to bank. These fields must not be sent when fundingDestination is set to mobile phone or email.
     * 
     */
    @JsonProperty("account_number")
    private String accountNumber;
    /**
     * Required if fundingDestination is set to bank. These fields must not be sent when fundingDestination is set to mobile phone or email.
     * 
     */
    @JsonProperty("routing_number")
    private String routingNumber;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * This field is optional. This field sets the description that will appear on the sub-merchant's deposits from Braintree.
     * 
     * @return
     *     The descriptor
     */
    @JsonProperty("descriptor")
    public String getDescriptor() {
        return descriptor;
    }

    /**
     * This field is optional. This field sets the description that will appear on the sub-merchant's deposits from Braintree.
     * 
     * @param descriptor
     *     The descriptor
     */
    @JsonProperty("descriptor")
    public void setDescriptor(String descriptor) {
        this.descriptor = descriptor;
    }

    public Funding withDescriptor(String descriptor) {
        this.descriptor = descriptor;
        return this;
    }

    /**
     * Funding destination is required, and the value can be email, mobile phone, or bank
     * (Required)
     * 
     * @return
     *     The destination
     */
    @JsonProperty("destination")
    public Funding.Destination getDestination() {
        return destination;
    }

    /**
     * Funding destination is required, and the value can be email, mobile phone, or bank
     * (Required)
     * 
     * @param destination
     *     The destination
     */
    @JsonProperty("destination")
    public void setDestination(Funding.Destination destination) {
        this.destination = destination;
    }

    public Funding withDestination(Funding.Destination destination) {
        this.destination = destination;
        return this;
    }

    /**
     * Email address. Required if funding destination is set to email
     * 
     * @return
     *     The email
     */
    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    /**
     * Email address. Required if funding destination is set to email
     * 
     * @param email
     *     The email
     */
    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    public Funding withEmail(String email) {
        this.email = email;
        return this;
    }

    /**
     * Mobile Phone. Required if funding destination is set to Mobile
     * 
     * @return
     *     The mobilePhone
     */
    @JsonProperty("mobile_phone")
    public String getMobilePhone() {
        return mobilePhone;
    }

    /**
     * Mobile Phone. Required if funding destination is set to Mobile
     * 
     * @param mobilePhone
     *     The mobile_phone
     */
    @JsonProperty("mobile_phone")
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public Funding withMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    /**
     * Required if fundingDestination is set to bank. These fields must not be sent when fundingDestination is set to mobile phone or email.
     * 
     * @return
     *     The accountNumber
     */
    @JsonProperty("account_number")
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Required if fundingDestination is set to bank. These fields must not be sent when fundingDestination is set to mobile phone or email.
     * 
     * @param accountNumber
     *     The account_number
     */
    @JsonProperty("account_number")
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Funding withAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    /**
     * Required if fundingDestination is set to bank. These fields must not be sent when fundingDestination is set to mobile phone or email.
     * 
     * @return
     *     The routingNumber
     */
    @JsonProperty("routing_number")
    public String getRoutingNumber() {
        return routingNumber;
    }

    /**
     * Required if fundingDestination is set to bank. These fields must not be sent when fundingDestination is set to mobile phone or email.
     * 
     * @param routingNumber
     *     The routing_number
     */
    @JsonProperty("routing_number")
    public void setRoutingNumber(String routingNumber) {
        this.routingNumber = routingNumber;
    }

    public Funding withRoutingNumber(String routingNumber) {
        this.routingNumber = routingNumber;
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

    public Funding withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(descriptor).append(destination).append(email).append(mobilePhone).append(accountNumber).append(routingNumber).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Funding) == false) {
            return false;
        }
        Funding rhs = ((Funding) other);
        return new EqualsBuilder().append(descriptor, rhs.descriptor).append(destination, rhs.destination).append(email, rhs.email).append(mobilePhone, rhs.mobilePhone).append(accountNumber, rhs.accountNumber).append(routingNumber, rhs.routingNumber).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

    @Generated("org.jsonschema2pojo")
    public static enum Destination {

        BANK("bank"),
        MOBILE_PHONE("mobile_phone"),
        EMAIL("email"),
        UNRECOGNIZED("unrecognized");
        private final String value;
        private static Map<String, Funding.Destination> constants = new HashMap<String, Funding.Destination>();

        static {
            for (Funding.Destination c: values()) {
                constants.put(c.value, c);
            }
        }

        private Destination(String value) {
            this.value = value;
        }

        @JsonValue
        @Override
        public String toString() {
            return this.value;
        }

        @JsonCreator
        public static Funding.Destination fromValue(String value) {
            Funding.Destination constant = constants.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}

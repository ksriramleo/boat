
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
 * Customer details
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "customer_id",
    "bt_customer_id",
    "payment_method_token"
})
public class Customer {

    /**
     * customer id generated for each customer
     * 
     */
    @JsonProperty("customer_id")
    private String customerId;
    /**
     * Customer ID created by braintree
     * 
     */
    @JsonProperty("bt_customer_id")
    private String btCustomerId;
    /**
     * Payment method token created by braintree against CC provided
     * 
     */
    @JsonProperty("payment_method_token")
    private String paymentMethodToken;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * customer id generated for each customer
     * 
     * @return
     *     The customerId
     */
    @JsonProperty("customer_id")
    public String getCustomerId() {
        return customerId;
    }

    /**
     * customer id generated for each customer
     * 
     * @param customerId
     *     The customer_id
     */
    @JsonProperty("customer_id")
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Customer withCustomerId(String customerId) {
        this.customerId = customerId;
        return this;
    }

    /**
     * Customer ID created by braintree
     * 
     * @return
     *     The btCustomerId
     */
    @JsonProperty("bt_customer_id")
    public String getBtCustomerId() {
        return btCustomerId;
    }

    /**
     * Customer ID created by braintree
     * 
     * @param btCustomerId
     *     The bt_customer_id
     */
    @JsonProperty("bt_customer_id")
    public void setBtCustomerId(String btCustomerId) {
        this.btCustomerId = btCustomerId;
    }

    public Customer withBtCustomerId(String btCustomerId) {
        this.btCustomerId = btCustomerId;
        return this;
    }

    /**
     * Payment method token created by braintree against CC provided
     * 
     * @return
     *     The paymentMethodToken
     */
    @JsonProperty("payment_method_token")
    public String getPaymentMethodToken() {
        return paymentMethodToken;
    }

    /**
     * Payment method token created by braintree against CC provided
     * 
     * @param paymentMethodToken
     *     The payment_method_token
     */
    @JsonProperty("payment_method_token")
    public void setPaymentMethodToken(String paymentMethodToken) {
        this.paymentMethodToken = paymentMethodToken;
    }

    public Customer withPaymentMethodToken(String paymentMethodToken) {
        this.paymentMethodToken = paymentMethodToken;
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

    public Customer withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(customerId).append(btCustomerId).append(paymentMethodToken).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Customer) == false) {
            return false;
        }
        Customer rhs = ((Customer) other);
        return new EqualsBuilder().append(customerId, rhs.customerId).append(btCustomerId, rhs.btCustomerId).append(paymentMethodToken, rhs.paymentMethodToken).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}

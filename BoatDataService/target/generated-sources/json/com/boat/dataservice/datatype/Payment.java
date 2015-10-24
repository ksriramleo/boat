
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
 * make payment transaction
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "bt_customer_id",
    "payment_method_token",
    "sub_merchant_id",
    "amount",
    "service_fee",
    "payment_id",
    "response_description",
    "response_authorization_code",
    "settlement_batch_id"
})
public class Payment {

    /**
     * customer id from brain tree
     * 
     */
    @JsonProperty("bt_customer_id")
    private String btCustomerId;
    /**
     * customer token that came back from brain tree
     * 
     */
    @JsonProperty("payment_method_token")
    private String paymentMethodToken;
    /**
     * brain tree merchant ID - sub merchant ID
     * 
     */
    @JsonProperty("sub_merchant_id")
    private String subMerchantId;
    /**
     * amount that needs to go to the merchant
     * 
     */
    @JsonProperty("amount")
    private String amount;
    /**
     * service fee to the master merchant
     * 
     */
    @JsonProperty("service_fee")
    private String serviceFee;
    /**
     * payment id that would be returned from customer
     * 
     */
    @JsonProperty("payment_id")
    private String paymentId;
    /**
     * response description. Mostly payment made, in case of error this would contain error message
     * 
     */
    @JsonProperty("response_description")
    private String responseDescription;
    /**
     * response authorization code. Unique code sent by BT
     * 
     */
    @JsonProperty("response_authorization_code")
    private String responseAuthorizationCode;
    /**
     * settlement batch ID
     * 
     */
    @JsonProperty("settlement_batch_id")
    private String settlementBatchId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * customer id from brain tree
     * 
     * @return
     *     The btCustomerId
     */
    @JsonProperty("bt_customer_id")
    public String getBtCustomerId() {
        return btCustomerId;
    }

    /**
     * customer id from brain tree
     * 
     * @param btCustomerId
     *     The bt_customer_id
     */
    @JsonProperty("bt_customer_id")
    public void setBtCustomerId(String btCustomerId) {
        this.btCustomerId = btCustomerId;
    }

    public Payment withBtCustomerId(String btCustomerId) {
        this.btCustomerId = btCustomerId;
        return this;
    }

    /**
     * customer token that came back from brain tree
     * 
     * @return
     *     The paymentMethodToken
     */
    @JsonProperty("payment_method_token")
    public String getPaymentMethodToken() {
        return paymentMethodToken;
    }

    /**
     * customer token that came back from brain tree
     * 
     * @param paymentMethodToken
     *     The payment_method_token
     */
    @JsonProperty("payment_method_token")
    public void setPaymentMethodToken(String paymentMethodToken) {
        this.paymentMethodToken = paymentMethodToken;
    }

    public Payment withPaymentMethodToken(String paymentMethodToken) {
        this.paymentMethodToken = paymentMethodToken;
        return this;
    }

    /**
     * brain tree merchant ID - sub merchant ID
     * 
     * @return
     *     The subMerchantId
     */
    @JsonProperty("sub_merchant_id")
    public String getSubMerchantId() {
        return subMerchantId;
    }

    /**
     * brain tree merchant ID - sub merchant ID
     * 
     * @param subMerchantId
     *     The sub_merchant_id
     */
    @JsonProperty("sub_merchant_id")
    public void setSubMerchantId(String subMerchantId) {
        this.subMerchantId = subMerchantId;
    }

    public Payment withSubMerchantId(String subMerchantId) {
        this.subMerchantId = subMerchantId;
        return this;
    }

    /**
     * amount that needs to go to the merchant
     * 
     * @return
     *     The amount
     */
    @JsonProperty("amount")
    public String getAmount() {
        return amount;
    }

    /**
     * amount that needs to go to the merchant
     * 
     * @param amount
     *     The amount
     */
    @JsonProperty("amount")
    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Payment withAmount(String amount) {
        this.amount = amount;
        return this;
    }

    /**
     * service fee to the master merchant
     * 
     * @return
     *     The serviceFee
     */
    @JsonProperty("service_fee")
    public String getServiceFee() {
        return serviceFee;
    }

    /**
     * service fee to the master merchant
     * 
     * @param serviceFee
     *     The service_fee
     */
    @JsonProperty("service_fee")
    public void setServiceFee(String serviceFee) {
        this.serviceFee = serviceFee;
    }

    public Payment withServiceFee(String serviceFee) {
        this.serviceFee = serviceFee;
        return this;
    }

    /**
     * payment id that would be returned from customer
     * 
     * @return
     *     The paymentId
     */
    @JsonProperty("payment_id")
    public String getPaymentId() {
        return paymentId;
    }

    /**
     * payment id that would be returned from customer
     * 
     * @param paymentId
     *     The payment_id
     */
    @JsonProperty("payment_id")
    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public Payment withPaymentId(String paymentId) {
        this.paymentId = paymentId;
        return this;
    }

    /**
     * response description. Mostly payment made, in case of error this would contain error message
     * 
     * @return
     *     The responseDescription
     */
    @JsonProperty("response_description")
    public String getResponseDescription() {
        return responseDescription;
    }

    /**
     * response description. Mostly payment made, in case of error this would contain error message
     * 
     * @param responseDescription
     *     The response_description
     */
    @JsonProperty("response_description")
    public void setResponseDescription(String responseDescription) {
        this.responseDescription = responseDescription;
    }

    public Payment withResponseDescription(String responseDescription) {
        this.responseDescription = responseDescription;
        return this;
    }

    /**
     * response authorization code. Unique code sent by BT
     * 
     * @return
     *     The responseAuthorizationCode
     */
    @JsonProperty("response_authorization_code")
    public String getResponseAuthorizationCode() {
        return responseAuthorizationCode;
    }

    /**
     * response authorization code. Unique code sent by BT
     * 
     * @param responseAuthorizationCode
     *     The response_authorization_code
     */
    @JsonProperty("response_authorization_code")
    public void setResponseAuthorizationCode(String responseAuthorizationCode) {
        this.responseAuthorizationCode = responseAuthorizationCode;
    }

    public Payment withResponseAuthorizationCode(String responseAuthorizationCode) {
        this.responseAuthorizationCode = responseAuthorizationCode;
        return this;
    }

    /**
     * settlement batch ID
     * 
     * @return
     *     The settlementBatchId
     */
    @JsonProperty("settlement_batch_id")
    public String getSettlementBatchId() {
        return settlementBatchId;
    }

    /**
     * settlement batch ID
     * 
     * @param settlementBatchId
     *     The settlement_batch_id
     */
    @JsonProperty("settlement_batch_id")
    public void setSettlementBatchId(String settlementBatchId) {
        this.settlementBatchId = settlementBatchId;
    }

    public Payment withSettlementBatchId(String settlementBatchId) {
        this.settlementBatchId = settlementBatchId;
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

    public Payment withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(btCustomerId).append(paymentMethodToken).append(subMerchantId).append(amount).append(serviceFee).append(paymentId).append(responseDescription).append(responseAuthorizationCode).append(settlementBatchId).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Payment) == false) {
            return false;
        }
        Payment rhs = ((Payment) other);
        return new EqualsBuilder().append(btCustomerId, rhs.btCustomerId).append(paymentMethodToken, rhs.paymentMethodToken).append(subMerchantId, rhs.subMerchantId).append(amount, rhs.amount).append(serviceFee, rhs.serviceFee).append(paymentId, rhs.paymentId).append(responseDescription, rhs.responseDescription).append(responseAuthorizationCode, rhs.responseAuthorizationCode).append(settlementBatchId, rhs.settlementBatchId).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}

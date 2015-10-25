
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


/**
 * Transaction Details
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "transaction_id",
    "transaction_type",
    "sub_merchant_id",
    "bt_customer_id",
    "item_upc",
    "amount",
    "status",
    "session_id"
})
public class TransactionInfo {

    /**
     * transaction id is unique for each transaction
     * 
     */
    @JsonProperty("transaction_id")
    private String transactionId;
    /**
     * Type of Transaction.
     * (Required)
     * 
     */
    @JsonProperty("transaction_type")
    private TransactionInfo.TransactionType transactionType;
    /**
     * braintree merchant id
     * 
     */
    @JsonProperty("sub_merchant_id")
    private String subMerchantId;
    /**
     * braintree customer id
     * 
     */
    @JsonProperty("bt_customer_id")
    private String btCustomerId;
    /**
     * upc id of the item
     * 
     */
    @JsonProperty("item_upc")
    private String itemUpc;
    /**
     * transaction amount
     * 
     */
    @JsonProperty("amount")
    private String amount;
    /**
     * Status of Transaction.
     * (Required)
     * 
     */
    @JsonProperty("status")
    private TransactionInfo.Status status;
    /**
     * session id
     * 
     */
    @JsonProperty("session_id")
    private String sessionId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * transaction id is unique for each transaction
     * 
     * @return
     *     The transactionId
     */
    @JsonProperty("transaction_id")
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * transaction id is unique for each transaction
     * 
     * @param transactionId
     *     The transaction_id
     */
    @JsonProperty("transaction_id")
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public TransactionInfo withTransactionId(String transactionId) {
        this.transactionId = transactionId;
        return this;
    }

    /**
     * Type of Transaction.
     * (Required)
     * 
     * @return
     *     The transactionType
     */
    @JsonProperty("transaction_type")
    public TransactionInfo.TransactionType getTransactionType() {
        return transactionType;
    }

    /**
     * Type of Transaction.
     * (Required)
     * 
     * @param transactionType
     *     The transaction_type
     */
    @JsonProperty("transaction_type")
    public void setTransactionType(TransactionInfo.TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public TransactionInfo withTransactionType(TransactionInfo.TransactionType transactionType) {
        this.transactionType = transactionType;
        return this;
    }

    /**
     * braintree merchant id
     * 
     * @return
     *     The subMerchantId
     */
    @JsonProperty("sub_merchant_id")
    public String getSubMerchantId() {
        return subMerchantId;
    }

    /**
     * braintree merchant id
     * 
     * @param subMerchantId
     *     The sub_merchant_id
     */
    @JsonProperty("sub_merchant_id")
    public void setSubMerchantId(String subMerchantId) {
        this.subMerchantId = subMerchantId;
    }

    public TransactionInfo withSubMerchantId(String subMerchantId) {
        this.subMerchantId = subMerchantId;
        return this;
    }

    /**
     * braintree customer id
     * 
     * @return
     *     The btCustomerId
     */
    @JsonProperty("bt_customer_id")
    public String getBtCustomerId() {
        return btCustomerId;
    }

    /**
     * braintree customer id
     * 
     * @param btCustomerId
     *     The bt_customer_id
     */
    @JsonProperty("bt_customer_id")
    public void setBtCustomerId(String btCustomerId) {
        this.btCustomerId = btCustomerId;
    }

    public TransactionInfo withBtCustomerId(String btCustomerId) {
        this.btCustomerId = btCustomerId;
        return this;
    }

    /**
     * upc id of the item
     * 
     * @return
     *     The itemUpc
     */
    @JsonProperty("item_upc")
    public String getItemUpc() {
        return itemUpc;
    }

    /**
     * upc id of the item
     * 
     * @param itemUpc
     *     The item_upc
     */
    @JsonProperty("item_upc")
    public void setItemUpc(String itemUpc) {
        this.itemUpc = itemUpc;
    }

    public TransactionInfo withItemUpc(String itemUpc) {
        this.itemUpc = itemUpc;
        return this;
    }

    /**
     * transaction amount
     * 
     * @return
     *     The amount
     */
    @JsonProperty("amount")
    public String getAmount() {
        return amount;
    }

    /**
     * transaction amount
     * 
     * @param amount
     *     The amount
     */
    @JsonProperty("amount")
    public void setAmount(String amount) {
        this.amount = amount;
    }

    public TransactionInfo withAmount(String amount) {
        this.amount = amount;
        return this;
    }

    /**
     * Status of Transaction.
     * (Required)
     * 
     * @return
     *     The status
     */
    @JsonProperty("status")
    public TransactionInfo.Status getStatus() {
        return status;
    }

    /**
     * Status of Transaction.
     * (Required)
     * 
     * @param status
     *     The status
     */
    @JsonProperty("status")
    public void setStatus(TransactionInfo.Status status) {
        this.status = status;
    }

    public TransactionInfo withStatus(TransactionInfo.Status status) {
        this.status = status;
        return this;
    }

    /**
     * session id
     * 
     * @return
     *     The sessionId
     */
    @JsonProperty("session_id")
    public String getSessionId() {
        return sessionId;
    }

    /**
     * session id
     * 
     * @param sessionId
     *     The session_id
     */
    @JsonProperty("session_id")
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public TransactionInfo withSessionId(String sessionId) {
        this.sessionId = sessionId;
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

    public TransactionInfo withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(transactionId).append(transactionType).append(subMerchantId).append(btCustomerId).append(itemUpc).append(amount).append(status).append(sessionId).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TransactionInfo) == false) {
            return false;
        }
        TransactionInfo rhs = ((TransactionInfo) other);
        return new EqualsBuilder().append(transactionId, rhs.transactionId).append(transactionType, rhs.transactionType).append(subMerchantId, rhs.subMerchantId).append(btCustomerId, rhs.btCustomerId).append(itemUpc, rhs.itemUpc).append(amount, rhs.amount).append(status, rhs.status).append(sessionId, rhs.sessionId).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

    @Generated("org.jsonschema2pojo")
    public static enum Status {

        IN_PROGRESS("in-progress"),
        COMPLETE("complete"),
        FAILED("failed");
        private final String value;
        private static Map<String, TransactionInfo.Status> constants = new HashMap<String, TransactionInfo.Status>();

        static {
            for (TransactionInfo.Status c: values()) {
                constants.put(c.value, c);
            }
        }

        private Status(String value) {
            this.value = value;
        }

        @JsonValue
        @Override
        public String toString() {
            return this.value;
        }

        @JsonCreator
        public static TransactionInfo.Status fromValue(String value) {
            TransactionInfo.Status constant = constants.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

    @Generated("org.jsonschema2pojo")
    public static enum TransactionType {

        ORDER("order"),
        PAYMENT("payment"),
        VOID("void");
        private final String value;
        private static Map<String, TransactionInfo.TransactionType> constants = new HashMap<String, TransactionInfo.TransactionType>();

        static {
            for (TransactionInfo.TransactionType c: values()) {
                constants.put(c.value, c);
            }
        }

        private TransactionType(String value) {
            this.value = value;
        }

        @JsonValue
        @Override
        public String toString() {
            return this.value;
        }

        @JsonCreator
        public static TransactionInfo.TransactionType fromValue(String value) {
            TransactionInfo.TransactionType constant = constants.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}

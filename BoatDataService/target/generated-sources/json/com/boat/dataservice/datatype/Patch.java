
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
 * JSON Patch
 * <p>
 * A JSON Patch object used for doing partial updates to resources.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "op",
    "item_id",
    "quantity"
})
public class Patch {

    /**
     * Patch operation to perform.Value required for add & remove operation can be any JSON value.
     * (Required)
     * 
     */
    @JsonProperty("op")
    private Patch.Op op;
    /**
     * item it is associated with
     * 
     */
    @JsonProperty("item_id")
    private String itemId;
    /**
     * quantity every time device should order for the item
     * 
     */
    @JsonProperty("quantity")
    private String quantity;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * Patch operation to perform.Value required for add & remove operation can be any JSON value.
     * (Required)
     * 
     * @return
     *     The op
     */
    @JsonProperty("op")
    public Patch.Op getOp() {
        return op;
    }

    /**
     * Patch operation to perform.Value required for add & remove operation can be any JSON value.
     * (Required)
     * 
     * @param op
     *     The op
     */
    @JsonProperty("op")
    public void setOp(Patch.Op op) {
        this.op = op;
    }

    public Patch withOp(Patch.Op op) {
        this.op = op;
        return this;
    }

    /**
     * item it is associated with
     * 
     * @return
     *     The itemId
     */
    @JsonProperty("item_id")
    public String getItemId() {
        return itemId;
    }

    /**
     * item it is associated with
     * 
     * @param itemId
     *     The item_id
     */
    @JsonProperty("item_id")
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public Patch withItemId(String itemId) {
        this.itemId = itemId;
        return this;
    }

    /**
     * quantity every time device should order for the item
     * 
     * @return
     *     The quantity
     */
    @JsonProperty("quantity")
    public String getQuantity() {
        return quantity;
    }

    /**
     * quantity every time device should order for the item
     * 
     * @param quantity
     *     The quantity
     */
    @JsonProperty("quantity")
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Patch withQuantity(String quantity) {
        this.quantity = quantity;
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

    public Patch withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(op).append(itemId).append(quantity).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Patch) == false) {
            return false;
        }
        Patch rhs = ((Patch) other);
        return new EqualsBuilder().append(op, rhs.op).append(itemId, rhs.itemId).append(quantity, rhs.quantity).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

    @Generated("org.jsonschema2pojo")
    public static enum Op {

        ADD("add"),
        REMOVE("remove"),
        REPLACE("replace");
        private final String value;
        private static Map<String, Patch.Op> constants = new HashMap<String, Patch.Op>();

        static {
            for (Patch.Op c: values()) {
                constants.put(c.value, c);
            }
        }

        private Op(String value) {
            this.value = value;
        }

        @JsonValue
        @Override
        public String toString() {
            return this.value;
        }

        @JsonCreator
        public static Patch.Op fromValue(String value) {
            Patch.Op constant = constants.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}

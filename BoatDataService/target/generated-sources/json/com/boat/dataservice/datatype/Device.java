
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
 * device details
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "device_id",
    "mac_id",
    "item_id",
    "bt_customer_id",
    "quantity"
})
public class Device {

    /**
     * device id generated for each customer
     * 
     */
    @JsonProperty("device_id")
    private String deviceId;
    /**
     * mac id of the device
     * (Required)
     * 
     */
    @JsonProperty("mac_id")
    private String macId;
    /**
     * item it is associated with
     * (Required)
     * 
     */
    @JsonProperty("item_id")
    private String itemId;
    /**
     * customer it is associated with
     * (Required)
     * 
     */
    @JsonProperty("bt_customer_id")
    private String btCustomerId;
    /**
     * quantity every time device should order for the item
     * (Required)
     * 
     */
    @JsonProperty("quantity")
    private String quantity;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * device id generated for each customer
     * 
     * @return
     *     The deviceId
     */
    @JsonProperty("device_id")
    public String getDeviceId() {
        return deviceId;
    }

    /**
     * device id generated for each customer
     * 
     * @param deviceId
     *     The device_id
     */
    @JsonProperty("device_id")
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Device withDeviceId(String deviceId) {
        this.deviceId = deviceId;
        return this;
    }

    /**
     * mac id of the device
     * (Required)
     * 
     * @return
     *     The macId
     */
    @JsonProperty("mac_id")
    public String getMacId() {
        return macId;
    }

    /**
     * mac id of the device
     * (Required)
     * 
     * @param macId
     *     The mac_id
     */
    @JsonProperty("mac_id")
    public void setMacId(String macId) {
        this.macId = macId;
    }

    public Device withMacId(String macId) {
        this.macId = macId;
        return this;
    }

    /**
     * item it is associated with
     * (Required)
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
     * (Required)
     * 
     * @param itemId
     *     The item_id
     */
    @JsonProperty("item_id")
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public Device withItemId(String itemId) {
        this.itemId = itemId;
        return this;
    }

    /**
     * customer it is associated with
     * (Required)
     * 
     * @return
     *     The btCustomerId
     */
    @JsonProperty("bt_customer_id")
    public String getBtCustomerId() {
        return btCustomerId;
    }

    /**
     * customer it is associated with
     * (Required)
     * 
     * @param btCustomerId
     *     The bt_customer_id
     */
    @JsonProperty("bt_customer_id")
    public void setBtCustomerId(String btCustomerId) {
        this.btCustomerId = btCustomerId;
    }

    public Device withBtCustomerId(String btCustomerId) {
        this.btCustomerId = btCustomerId;
        return this;
    }

    /**
     * quantity every time device should order for the item
     * (Required)
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
     * (Required)
     * 
     * @param quantity
     *     The quantity
     */
    @JsonProperty("quantity")
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Device withQuantity(String quantity) {
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

    public Device withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(deviceId).append(macId).append(itemId).append(btCustomerId).append(quantity).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Device) == false) {
            return false;
        }
        Device rhs = ((Device) other);
        return new EqualsBuilder().append(deviceId, rhs.deviceId).append(macId, rhs.macId).append(itemId, rhs.itemId).append(btCustomerId, rhs.btCustomerId).append(quantity, rhs.quantity).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}

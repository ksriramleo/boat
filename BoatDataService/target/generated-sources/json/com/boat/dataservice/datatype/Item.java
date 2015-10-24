
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
 * item details
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "item_id",
    "item_upc",
    "item_name",
    "item_desc"
})
public class Item {

    /**
     * item id generated for each customer
     * 
     */
    @JsonProperty("item_id")
    private String itemId;
    /**
     * upc id of the item
     * 
     */
    @JsonProperty("item_upc")
    private String itemUpc;
    /**
     * item name
     * 
     */
    @JsonProperty("item_name")
    private String itemName;
    /**
     * item description
     * 
     */
    @JsonProperty("item_desc")
    private String itemDesc;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * item id generated for each customer
     * 
     * @return
     *     The itemId
     */
    @JsonProperty("item_id")
    public String getItemId() {
        return itemId;
    }

    /**
     * item id generated for each customer
     * 
     * @param itemId
     *     The item_id
     */
    @JsonProperty("item_id")
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public Item withItemId(String itemId) {
        this.itemId = itemId;
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

    public Item withItemUpc(String itemUpc) {
        this.itemUpc = itemUpc;
        return this;
    }

    /**
     * item name
     * 
     * @return
     *     The itemName
     */
    @JsonProperty("item_name")
    public String getItemName() {
        return itemName;
    }

    /**
     * item name
     * 
     * @param itemName
     *     The item_name
     */
    @JsonProperty("item_name")
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Item withItemName(String itemName) {
        this.itemName = itemName;
        return this;
    }

    /**
     * item description
     * 
     * @return
     *     The itemDesc
     */
    @JsonProperty("item_desc")
    public String getItemDesc() {
        return itemDesc;
    }

    /**
     * item description
     * 
     * @param itemDesc
     *     The item_desc
     */
    @JsonProperty("item_desc")
    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public Item withItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
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

    public Item withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(itemId).append(itemUpc).append(itemName).append(itemDesc).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Item) == false) {
            return false;
        }
        Item rhs = ((Item) other);
        return new EqualsBuilder().append(itemId, rhs.itemId).append(itemUpc, rhs.itemUpc).append(itemName, rhs.itemName).append(itemDesc, rhs.itemDesc).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}

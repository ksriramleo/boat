
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
 * Item Catalog
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "catalog_id",
    "item_upc",
    "sub_merchant_id",
    "price",
    "quantity",
    "availability"
})
public class Catalog {

    /**
     * catalog id generated for each item
     * 
     */
    @JsonProperty("catalog_id")
    private String catalogId;
    /**
     * upc id of the item
     * 
     */
    @JsonProperty("item_upc")
    private String itemUpc;
    /**
     * braintree merchant id
     * 
     */
    @JsonProperty("sub_merchant_id")
    private String subMerchantId;
    /**
     * item price
     * 
     */
    @JsonProperty("price")
    private String price;
    /**
     * quantity available with merchant
     * 
     */
    @JsonProperty("quantity")
    private String quantity;
    /**
     * item availability with merchant
     * 
     */
    @JsonProperty("availability")
    private Boolean availability;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * catalog id generated for each item
     * 
     * @return
     *     The catalogId
     */
    @JsonProperty("catalog_id")
    public String getCatalogId() {
        return catalogId;
    }

    /**
     * catalog id generated for each item
     * 
     * @param catalogId
     *     The catalog_id
     */
    @JsonProperty("catalog_id")
    public void setCatalogId(String catalogId) {
        this.catalogId = catalogId;
    }

    public Catalog withCatalogId(String catalogId) {
        this.catalogId = catalogId;
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

    public Catalog withItemUpc(String itemUpc) {
        this.itemUpc = itemUpc;
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

    public Catalog withSubMerchantId(String subMerchantId) {
        this.subMerchantId = subMerchantId;
        return this;
    }

    /**
     * item price
     * 
     * @return
     *     The price
     */
    @JsonProperty("price")
    public String getPrice() {
        return price;
    }

    /**
     * item price
     * 
     * @param price
     *     The price
     */
    @JsonProperty("price")
    public void setPrice(String price) {
        this.price = price;
    }

    public Catalog withPrice(String price) {
        this.price = price;
        return this;
    }

    /**
     * quantity available with merchant
     * 
     * @return
     *     The quantity
     */
    @JsonProperty("quantity")
    public String getQuantity() {
        return quantity;
    }

    /**
     * quantity available with merchant
     * 
     * @param quantity
     *     The quantity
     */
    @JsonProperty("quantity")
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Catalog withQuantity(String quantity) {
        this.quantity = quantity;
        return this;
    }

    /**
     * item availability with merchant
     * 
     * @return
     *     The availability
     */
    @JsonProperty("availability")
    public Boolean getAvailability() {
        return availability;
    }

    /**
     * item availability with merchant
     * 
     * @param availability
     *     The availability
     */
    @JsonProperty("availability")
    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    public Catalog withAvailability(Boolean availability) {
        this.availability = availability;
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

    public Catalog withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(catalogId).append(itemUpc).append(subMerchantId).append(price).append(quantity).append(availability).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Catalog) == false) {
            return false;
        }
        Catalog rhs = ((Catalog) other);
        return new EqualsBuilder().append(catalogId, rhs.catalogId).append(itemUpc, rhs.itemUpc).append(subMerchantId, rhs.subMerchantId).append(price, rhs.price).append(quantity, rhs.quantity).append(availability, rhs.availability).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}

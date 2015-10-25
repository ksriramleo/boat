
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
 * Merchant details
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "merchant_id",
    "individual",
    "business",
    "funding",
    "id",
    "status"
})
public class MerchantOnboarding {

    /**
     * merchant id generated for each merchant in application
     * 
     */
    @JsonProperty("merchant_id")
    private String merchantId;
    /**
     * Sub Merchant information associated with a merchant account.
     * 
     */
    @JsonProperty("individual")
    private Individual individual;
    @JsonProperty("business")
    private Business business;
    @JsonProperty("funding")
    private Funding funding;
    /**
     * Specifies the ID of the Sub Merchant's account, which can be referenced when creating transactions with service fees. Max 32 characters; must be unique, cannot be 'all' or 'new', and must contain only letters, numbers, _ and -. If not provided, Braintree will automatically generate one.
     * 
     */
    @JsonProperty("id")
    private String id;
    /**
     * SUCCESS or FAILED
     * 
     */
    @JsonProperty("status")
    private String status;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * merchant id generated for each merchant in application
     * 
     * @return
     *     The merchantId
     */
    @JsonProperty("merchant_id")
    public String getMerchantId() {
        return merchantId;
    }

    /**
     * merchant id generated for each merchant in application
     * 
     * @param merchantId
     *     The merchant_id
     */
    @JsonProperty("merchant_id")
    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public MerchantOnboarding withMerchantId(String merchantId) {
        this.merchantId = merchantId;
        return this;
    }

    /**
     * Sub Merchant information associated with a merchant account.
     * 
     * @return
     *     The individual
     */
    @JsonProperty("individual")
    public Individual getIndividual() {
        return individual;
    }

    /**
     * Sub Merchant information associated with a merchant account.
     * 
     * @param individual
     *     The individual
     */
    @JsonProperty("individual")
    public void setIndividual(Individual individual) {
        this.individual = individual;
    }

    public MerchantOnboarding withIndividual(Individual individual) {
        this.individual = individual;
        return this;
    }

    /**
     * 
     * @return
     *     The business
     */
    @JsonProperty("business")
    public Business getBusiness() {
        return business;
    }

    /**
     * 
     * @param business
     *     The business
     */
    @JsonProperty("business")
    public void setBusiness(Business business) {
        this.business = business;
    }

    public MerchantOnboarding withBusiness(Business business) {
        this.business = business;
        return this;
    }

    /**
     * 
     * @return
     *     The funding
     */
    @JsonProperty("funding")
    public Funding getFunding() {
        return funding;
    }

    /**
     * 
     * @param funding
     *     The funding
     */
    @JsonProperty("funding")
    public void setFunding(Funding funding) {
        this.funding = funding;
    }

    public MerchantOnboarding withFunding(Funding funding) {
        this.funding = funding;
        return this;
    }

    /**
     * Specifies the ID of the Sub Merchant's account, which can be referenced when creating transactions with service fees. Max 32 characters; must be unique, cannot be 'all' or 'new', and must contain only letters, numbers, _ and -. If not provided, Braintree will automatically generate one.
     * 
     * @return
     *     The id
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * Specifies the ID of the Sub Merchant's account, which can be referenced when creating transactions with service fees. Max 32 characters; must be unique, cannot be 'all' or 'new', and must contain only letters, numbers, _ and -. If not provided, Braintree will automatically generate one.
     * 
     * @param id
     *     The id
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    public MerchantOnboarding withId(String id) {
        this.id = id;
        return this;
    }

    /**
     * SUCCESS or FAILED
     * 
     * @return
     *     The status
     */
    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    /**
     * SUCCESS or FAILED
     * 
     * @param status
     *     The status
     */
    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    public MerchantOnboarding withStatus(String status) {
        this.status = status;
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

    public MerchantOnboarding withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(merchantId).append(individual).append(business).append(funding).append(id).append(status).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof MerchantOnboarding) == false) {
            return false;
        }
        MerchantOnboarding rhs = ((MerchantOnboarding) other);
        return new EqualsBuilder().append(merchantId, rhs.merchantId).append(individual, rhs.individual).append(business, rhs.business).append(funding, rhs.funding).append(id, rhs.id).append(status, rhs.status).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}


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

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "legal_name",
    "dba_name",
    "tax_id",
    "street_address",
    "locality",
    "region",
    "postal_code"
})
public class Business {

    /**
     * Business Legal name. Required if tax id is provided
     * 
     */
    @JsonProperty("legal_name")
    private String legalName;
    /**
     * Doing business as name
     * 
     */
    @JsonProperty("dba_name")
    private String dbaName;
    /**
     * The 9-digit numeric value associated with the business' tax identity. Required if legal_name has been provided. eg. 987654321
     * 
     */
    @JsonProperty("tax_id")
    private String taxId;
    /**
     * The street address. Street address must be less than or equal to 255 characters. Must contain at least 1 digit. eg. 111 Main St
     * 
     */
    @JsonProperty("street_address")
    private String streetAddress;
    /**
     * The locality/city. 255 character maximum. i.e. city eg. Chicago
     * 
     */
    @JsonProperty("locality")
    private String locality;
    /**
     * The state or province. The region must be a 2-letter abbreviation and must be less than or equal to 255 characters.eg. FL or IL
     * 
     */
    @JsonProperty("region")
    private String region;
    /**
     * Postal code must be a string of 5 or 9 alphanumeric digits, optionally separated by a dash or a space. Spaces, hyphens, and all other special characters are ignored.. eg. 21030
     * 
     */
    @JsonProperty("postal_code")
    private String postalCode;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * Business Legal name. Required if tax id is provided
     * 
     * @return
     *     The legalName
     */
    @JsonProperty("legal_name")
    public String getLegalName() {
        return legalName;
    }

    /**
     * Business Legal name. Required if tax id is provided
     * 
     * @param legalName
     *     The legal_name
     */
    @JsonProperty("legal_name")
    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    public Business withLegalName(String legalName) {
        this.legalName = legalName;
        return this;
    }

    /**
     * Doing business as name
     * 
     * @return
     *     The dbaName
     */
    @JsonProperty("dba_name")
    public String getDbaName() {
        return dbaName;
    }

    /**
     * Doing business as name
     * 
     * @param dbaName
     *     The dba_name
     */
    @JsonProperty("dba_name")
    public void setDbaName(String dbaName) {
        this.dbaName = dbaName;
    }

    public Business withDbaName(String dbaName) {
        this.dbaName = dbaName;
        return this;
    }

    /**
     * The 9-digit numeric value associated with the business' tax identity. Required if legal_name has been provided. eg. 987654321
     * 
     * @return
     *     The taxId
     */
    @JsonProperty("tax_id")
    public String getTaxId() {
        return taxId;
    }

    /**
     * The 9-digit numeric value associated with the business' tax identity. Required if legal_name has been provided. eg. 987654321
     * 
     * @param taxId
     *     The tax_id
     */
    @JsonProperty("tax_id")
    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public Business withTaxId(String taxId) {
        this.taxId = taxId;
        return this;
    }

    /**
     * The street address. Street address must be less than or equal to 255 characters. Must contain at least 1 digit. eg. 111 Main St
     * 
     * @return
     *     The streetAddress
     */
    @JsonProperty("street_address")
    public String getStreetAddress() {
        return streetAddress;
    }

    /**
     * The street address. Street address must be less than or equal to 255 characters. Must contain at least 1 digit. eg. 111 Main St
     * 
     * @param streetAddress
     *     The street_address
     */
    @JsonProperty("street_address")
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public Business withStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
        return this;
    }

    /**
     * The locality/city. 255 character maximum. i.e. city eg. Chicago
     * 
     * @return
     *     The locality
     */
    @JsonProperty("locality")
    public String getLocality() {
        return locality;
    }

    /**
     * The locality/city. 255 character maximum. i.e. city eg. Chicago
     * 
     * @param locality
     *     The locality
     */
    @JsonProperty("locality")
    public void setLocality(String locality) {
        this.locality = locality;
    }

    public Business withLocality(String locality) {
        this.locality = locality;
        return this;
    }

    /**
     * The state or province. The region must be a 2-letter abbreviation and must be less than or equal to 255 characters.eg. FL or IL
     * 
     * @return
     *     The region
     */
    @JsonProperty("region")
    public String getRegion() {
        return region;
    }

    /**
     * The state or province. The region must be a 2-letter abbreviation and must be less than or equal to 255 characters.eg. FL or IL
     * 
     * @param region
     *     The region
     */
    @JsonProperty("region")
    public void setRegion(String region) {
        this.region = region;
    }

    public Business withRegion(String region) {
        this.region = region;
        return this;
    }

    /**
     * Postal code must be a string of 5 or 9 alphanumeric digits, optionally separated by a dash or a space. Spaces, hyphens, and all other special characters are ignored.. eg. 21030
     * 
     * @return
     *     The postalCode
     */
    @JsonProperty("postal_code")
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Postal code must be a string of 5 or 9 alphanumeric digits, optionally separated by a dash or a space. Spaces, hyphens, and all other special characters are ignored.. eg. 21030
     * 
     * @param postalCode
     *     The postal_code
     */
    @JsonProperty("postal_code")
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Business withPostalCode(String postalCode) {
        this.postalCode = postalCode;
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

    public Business withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(legalName).append(dbaName).append(taxId).append(streetAddress).append(locality).append(region).append(postalCode).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Business) == false) {
            return false;
        }
        Business rhs = ((Business) other);
        return new EqualsBuilder().append(legalName, rhs.legalName).append(dbaName, rhs.dbaName).append(taxId, rhs.taxId).append(streetAddress, rhs.streetAddress).append(locality, rhs.locality).append(region, rhs.region).append(postalCode, rhs.postalCode).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}

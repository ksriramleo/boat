
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
 * Sub Merchant information associated with a merchant account.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "first_name",
    "last_name",
    "phone_number",
    "email",
    "date_of_birth",
    "ssn",
    "street_address",
    "locality",
    "region",
    "postal_code"
})
public class Individual {

    /**
     * Individuals first name
     * 
     */
    @JsonProperty("first_name")
    private String firstName;
    /**
     * Individual last name
     * 
     */
    @JsonProperty("last_name")
    private String lastName;
    /**
     * customer phone number, keeping it string so that it can accommodate +
     * 
     */
    @JsonProperty("phone_number")
    private String phoneNumber;
    /**
     * Email address comprised of ASCII characters.
     * 
     */
    @JsonProperty("email")
    private String email;
    /**
     * The applicant's date of birth. Values can be passed as YYYYMMDD or YYYY-MM-DD.eg 1981-11-19 format
     * 
     */
    @JsonProperty("date_of_birth")
    private String dateOfBirth;
    /**
     * Individual SSN in XXX-XX-XXXX format. eg 456-45-4567
     * 
     */
    @JsonProperty("ssn")
    private String ssn;
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
     * Individuals first name
     * 
     * @return
     *     The firstName
     */
    @JsonProperty("first_name")
    public String getFirstName() {
        return firstName;
    }

    /**
     * Individuals first name
     * 
     * @param firstName
     *     The first_name
     */
    @JsonProperty("first_name")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Individual withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    /**
     * Individual last name
     * 
     * @return
     *     The lastName
     */
    @JsonProperty("last_name")
    public String getLastName() {
        return lastName;
    }

    /**
     * Individual last name
     * 
     * @param lastName
     *     The last_name
     */
    @JsonProperty("last_name")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Individual withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    /**
     * customer phone number, keeping it string so that it can accommodate +
     * 
     * @return
     *     The phoneNumber
     */
    @JsonProperty("phone_number")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * customer phone number, keeping it string so that it can accommodate +
     * 
     * @param phoneNumber
     *     The phone_number
     */
    @JsonProperty("phone_number")
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Individual withPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    /**
     * Email address comprised of ASCII characters.
     * 
     * @return
     *     The email
     */
    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    /**
     * Email address comprised of ASCII characters.
     * 
     * @param email
     *     The email
     */
    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    public Individual withEmail(String email) {
        this.email = email;
        return this;
    }

    /**
     * The applicant's date of birth. Values can be passed as YYYYMMDD or YYYY-MM-DD.eg 1981-11-19 format
     * 
     * @return
     *     The dateOfBirth
     */
    @JsonProperty("date_of_birth")
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * The applicant's date of birth. Values can be passed as YYYYMMDD or YYYY-MM-DD.eg 1981-11-19 format
     * 
     * @param dateOfBirth
     *     The date_of_birth
     */
    @JsonProperty("date_of_birth")
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Individual withDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    /**
     * Individual SSN in XXX-XX-XXXX format. eg 456-45-4567
     * 
     * @return
     *     The ssn
     */
    @JsonProperty("ssn")
    public String getSsn() {
        return ssn;
    }

    /**
     * Individual SSN in XXX-XX-XXXX format. eg 456-45-4567
     * 
     * @param ssn
     *     The ssn
     */
    @JsonProperty("ssn")
    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public Individual withSsn(String ssn) {
        this.ssn = ssn;
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

    public Individual withStreetAddress(String streetAddress) {
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

    public Individual withLocality(String locality) {
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

    public Individual withRegion(String region) {
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

    public Individual withPostalCode(String postalCode) {
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

    public Individual withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(firstName).append(lastName).append(phoneNumber).append(email).append(dateOfBirth).append(ssn).append(streetAddress).append(locality).append(region).append(postalCode).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Individual) == false) {
            return false;
        }
        Individual rhs = ((Individual) other);
        return new EqualsBuilder().append(firstName, rhs.firstName).append(lastName, rhs.lastName).append(phoneNumber, rhs.phoneNumber).append(email, rhs.email).append(dateOfBirth, rhs.dateOfBirth).append(ssn, rhs.ssn).append(streetAddress, rhs.streetAddress).append(locality, rhs.locality).append(region, rhs.region).append(postalCode, rhs.postalCode).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}

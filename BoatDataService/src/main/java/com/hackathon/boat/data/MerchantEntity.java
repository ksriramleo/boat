package com.hackathon.boat.data;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by awmishra on 10/24/2015.
 * Merchant Entity
 */
@Data
@Entity
@Table(name = "merchant", schema = "boat")
public class MerchantEntity {

    /**
     * Merchant Id
     */
    @Id
    @GeneratedValue
    @Column(name = "MERHANT_ID")
    private Long merchantId;

    /**
     * Doing Business As Name
     */
    @Column(name = "BUSINESS_NAME",
            nullable = true,
            insertable = true,
            updatable = false,
            length = 255)
    private String businessName;

    /**
     * Merchant Account Id at BrainTree
     */
    @Column(name = "SUB_MERCHANT_ID",
            nullable = true,
            insertable = true,
            updatable = false,
            length = 255)
    private String subMerchantId;
}

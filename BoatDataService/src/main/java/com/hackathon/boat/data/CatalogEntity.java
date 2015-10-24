package com.hackathon.boat.data;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by awmishra on 10/24/2015.
 */
@Data
@Entity
@Table(name= "catalog", schema = "boat")
public class CatalogEntity {

    /**
     * Catalog Id
     */
    @Id
    @GeneratedValue
    @Column(name = "CATALOG_ID")
    private Long catalogId;

    /**
     * Item UPC
     */
    @Column(name = "ITEM_UPC",
            nullable = true,
            insertable = true,
            updatable = false,
            length = 255)
    private String itemUpc;

    /**
     * Sub Merchant Id at BrainTree
     */
    @Column(name = "SUB_MERCHANT_ID",
            nullable = true,
            insertable = true,
            updatable = false,
            length = 255)
    private String subMerchantId;

    /**
     * Price
     */
    @Column(name = "PRICE")
    private Double price;

    /**
     * Quantity
     */
    @Column(name = "QUANTITY")
    private Long quantity;

    /**
     * Availability
     */
    @Column(name = "AVAILABILITY")
    private Boolean availability;
}

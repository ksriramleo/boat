package com.hackathon.boat.data;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by awmishra on 10/24/2015.
 * Device Entity
 */
@Entity
@Data
@Table(name = "device", schema = "boat")
public class DeviceEntity {

    /**
     * Device Id
     */
    @Id
    @GeneratedValue
    @Column(name = "DEVICE_ID")
    private long deviceId;

    /**
     * MAC ID
     */
    @Column(name = "MAC_ID",
            nullable = true,
            insertable = true,
            updatable = false,
            length = 255)
    private String macId;

    /**
     * Item Id
     */
    @Column(name = "ITEM_ID",
            nullable = true,
            insertable = true,
            updatable = false,
            length = 11)
    private Long itemId;

    /**
     * Braintree customerId
     */
    @Column(name = "BT_CUSTOMER_ID",
            nullable = true,
            insertable = true,
            updatable = false,
            length = 255)
    private String btCustomerId;

    /**
     * Quantity of Item
     */
    @Column(name = "QUANTITY",
            nullable = true,
            insertable = true,
            updatable = false,
            length = 11)
    private Long quantity;

}

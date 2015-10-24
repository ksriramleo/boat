package com.hackathon.boat.data;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by awmishra on 10/24/2015.
 * Customer Entity
 */
@Data
@Entity
@Table(name= "customer", schema= "boat")
public class CustomerEntity {

    /**
     * Generated customer id
      */
    @Id
    @GeneratedValue
    @Column(name = "CUSTOMER_ID")
    private Long customerId;

    /**
     * Brain Tree Customer Id
     */
    @Column(name = "BT_CUSTOMER_ID",
            nullable = false,
            insertable = true,
            updatable = false,
            length = 255)
    private String btCustomerId;

    /**
     * Payment Method Token
     */
    @Column(name = "PAYMENT_METHOD_TOKEN",
            nullable = false,
            insertable = true,
            updatable = false,
            length = 255)
    private String paymentMethodToken;

}

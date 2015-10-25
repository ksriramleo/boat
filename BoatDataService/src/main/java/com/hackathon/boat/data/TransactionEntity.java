package com.hackathon.boat.data;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by awmishra on 10/24/2015.
 */
@Data
@Entity
@Table(name = "transaction" , schema = "boat")
public class TransactionEntity {

    /**
     * Transaction Id
     */
    @Id
    @GeneratedValue
    @Column(name = "SERIAL_ID")
    private Long serialId;

    /**
     * Transaction Id
     */
    @Column(name = "TRANSACTION_ID",
            nullable = true,
            insertable = true,
            updatable = false,
            length = 50)
    private String transactionId;

    /**
     * Transaction Type
     * ORDER or PAYMENT or VOID
     */
    @Column(name = "TRANSACTION_TYPE",
            nullable = true,
            insertable = true,
            updatable = false,
            length = 50)
    private String transactionType;

    /**
     * Merchant Id
     */
    @Column(name = "SUB_MERCHANT_ID",
            nullable = true,
            insertable = true,
            updatable = false,
            length = 255)
    private String subMerchantId;

    /**
     * Customer Id
     */
    @Column(name = "BT_CUSTOMER_ID",
            nullable = true,
            insertable = true,
            updatable = false,
            length = 255)
    private String btCustomerId;

    @Column(name = "ITEM_UPC",
            nullable = false,
            insertable = true,
            updatable = true,
            length = 255)
    private String itemUpc;

    /**
     * Transaction Amount
     */
    @Column(name = "AMOUNT")
    private Double amount;

    /**
     *  Transaction Status
     *  IN-PROGRESS or COMPLETE
     */
    @Column(name = "STATUS")
    private String status;

    /**
     * Session_id
     * Session Id is unique for one complete flow
     */
    @Column(name = "SESSION_ID")
    private String sessionId;



}

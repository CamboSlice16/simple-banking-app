package com.camdyn.simplebankingapp.datastructure;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="transactions")
public class Transaction {

    @Id
    @Column(name="transaction_id")
    private long id;

    @Column(name="transaction_type")
    private String type;

    // @Column(name="transaction_date")
    // private Date date;

    @Column(name="amount")
    private float amount;

    @Column(name="account_to")
    private String account_to_id;

    @Column(name="account_from")
    private String account_from_id;
}

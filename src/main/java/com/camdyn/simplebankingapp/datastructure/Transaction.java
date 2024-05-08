package com.camdyn.simplebankingapp.datastructure;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="transactions")
public class Transaction {

    @Id
    @GeneratedValue
    @Column(name="transaction_id")
    private Long id;

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

    @Override
    public String toString() {
        return "Transaction [id: " + id + ", Type: " + type + "Amount: " + amount + "To: " + account_to_id + "From: " + account_from_id + "]";
    }
}

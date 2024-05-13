package com.camdyn.simplebankingapp.datastructure;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="transaction_id")
    private Long id;

    @Column(name="transaction_type")
    private String type;

    // @Column(name="transaction_date")
    // private Date date;

    @Column(name="amount")
    private double amount;

    @Column(name="account_to")
    private Long account_to_id;

    @Column(name="account_from")
    private Long account_from_id;

    @Override
    public String toString() {
        return "Transaction [id: " + id + ", Type: " + type + "Amount: " + amount + "To: " + account_to_id + "From: " + account_from_id + "]";
    }

    // Getters

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public Long getAccountToId() {
        return account_to_id;
    }

    public Long getAccountFromId() {
        return account_from_id;
    }

    // Setters

    public void setType(String type) {
        this.type = type;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setAccountToId(Long id) {
        account_to_id = id;
    }

    public void setAccountFromId(Long id) {
        account_from_id = id;
    }
}

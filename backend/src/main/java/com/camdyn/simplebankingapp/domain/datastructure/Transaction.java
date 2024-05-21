package com.camdyn.simplebankingapp.domain.datastructure;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * JPA Entity class for Transaction object
 * @author camdyn
 */

@Entity
@Table(name="transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id")
    private Long id;

    @Column(name="type")
    private String type;

    // @Column(name="timestamp")
    // private Date date;

    @Column(name="amount")
    private double amount;

    @Column(name="account_id")
    private Long account_id;

    // Constructors

    public Transaction(TransactionType type, double amount, long account_id) {
        this.amount = amount;
        this.account_id = account_id;
        this.type = type.label;
    }

    public Transaction() {}

    // Enum

    public enum TransactionType {
        DEPOSIT("deposit"),
        WITHDRAWAL("withdrawal"),
        TRANSFER("transfer");

        public final String label;

        private TransactionType(String label) {
            this.label = label;
        }
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

    public Long getAccountId() {
        return account_id;
    }

    // Setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setAccountId(Long id) {
        account_id = id;
    }

    // Misc

    @Override
    public String toString() {
        return "Transaction [id: " + id + ", Type: " + type + "Amount: " + amount + "To: " + account_id + "]";
    }
}

package com.camdyn.simplebankingapp.domain.datastructure;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="accounts")
public class Account {

    @Id
    @GeneratedValue
    @Column(name="id")
    private long id;

    @Column(name="type")
    private String type;

    @Column(name="balance")
    private float balance;

    @Column(name="owner_id")
    private long owner;

    // Constructors

    public Account(String type, long owner) {
        this.type = type;
        this.owner = owner;
        this.balance = (float) 0.00;
    }

    public Account(String type, float balance, long owner) {
        this.type = type;
        this.balance = balance;
        this.owner = owner;
    }

    public Account() {}

    // Enum

    public enum AccountType {
        CHECKING("checking"),
        SAVINGS("saving"),
        CREDIT("credit");

        public final String label;

        private AccountType(String label) {
            this.label = label;
        }
    }

    // Getters

    public long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public float getBalance() {
        return balance;
    }

    public long getOwner() {
        return owner;
    }

    // Setters

    public void setId(long id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    // Replaced by functions below
    // public void setBalance(float balance) {
    //     this.balance = balance;
    // }

    public void setOwner(long owner) {
        this.owner = owner;
    }

    // Misc

    public void subtractBalance(float diff) {
        balance -= diff;
    }

    public void addBalance(float diff) {
        balance += diff;
    }

    @Override
    public String toString() {
        return "Account [id: " + id + ", Type: " + type + "Balance: " + balance + "Owner: " + owner + "]";
    }
}

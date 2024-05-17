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
    @Column(name="account_id")
    private long id;

    @Column(name="account_type")
    private String type;

    @Column(name="account_balance")
    private float balance;

    @Column(name="owner_id")
    private String ownerId;

    @Override
    public String toString() {
        return "Account [id: " + id + ", Type: " + type + "Balance: " + balance + "Owner ID: " + ownerId + "]";
    }
}

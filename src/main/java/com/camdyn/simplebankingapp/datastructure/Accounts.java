package com.camdyn.simplebankingapp.datastructure;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="accounts")
public class Accounts {

    @Id
    @Column(name="account_id")
    private long id;

    @Column(name="account_type")
    private String type;

    @Column(name="account_balance")
    private float balance;
}

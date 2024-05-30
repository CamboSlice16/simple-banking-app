package com.camdyn.simplebankingapp.usecase;

/**
 * Class used to receive transfer data from frontend
 * @author camdyn
 */

public class Transfer {

    private long accountTo;     // Account ID (receiving)
    private long accountFrom;   // Account ID (giving)
    private double amount;      // Transfer amount

    public Transfer() {}

    public Transfer(long accountTo, long accountFrom, double amount) {
        this.accountTo = accountTo;
        this.accountFrom = accountFrom;
        this.amount = amount;
    }

    // Getters

    public long getAccountTo() {
        return accountTo;
    }

    public long getAccountFrom() {
        return accountFrom;
    }

    public double getAmount() {
        return amount;
    }

    // Setters

    public void setAccountTo(long accountTo) {
        this.accountTo = accountTo;
    }

    public void setAccountFrom(long accountFrom) {
        this.accountFrom = accountFrom;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

}

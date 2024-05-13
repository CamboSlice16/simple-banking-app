package com.camdyn.simplebankingapp.repo;

import com.camdyn.simplebankingapp.datastructure.Transaction;

public interface TransactionRepo {
    Transaction save(Transaction transaction);
    Transaction getTransactionById(Long id);
    void deleteTransaction(Transaction transaction);
    // List<Transaction> getTransactionsByUsername(String username);
}

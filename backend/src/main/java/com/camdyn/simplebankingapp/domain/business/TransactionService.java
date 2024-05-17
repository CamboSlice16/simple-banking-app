package com.camdyn.simplebankingapp.domain.business;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.camdyn.simplebankingapp.domain.datastructure.Transaction;
import com.camdyn.simplebankingapp.domain.repo.AccountRepo;
import com.camdyn.simplebankingapp.domain.repo.TransactionRepo;
import com.camdyn.simplebankingapp.domain.repo.UserRepo;

/**
 * Business Tier class for the Transaction Library
 * @author camdyn
 */

@Repository
class TransactionService {

    private final TransactionRepo transactionRepo;
    // private final AccountRepo accountRepo;
    // private final UserRepo userRepo;

    public TransactionService(TransactionRepo transactionRepo, AccountRepo accountRepo, UserRepo userRepo) {
        this.transactionRepo = transactionRepo;
        // this.accountRepo = accountRepo;
        // this.userRepo = userRepo;
    }

    // Create

    public Transaction createDeposit(double amount, long account_to_id) {
        return transactionRepo.save(new Transaction(Transaction.TransactionType.DEPOSIT, amount, account_to_id));
    }

    // Read

    public List<Transaction> findAllTransactions() {
        return transactionRepo.findAll();
    }

    public Transaction findById(long id) {
        Optional<Transaction> t =  transactionRepo.findById(id);
        if (t.isEmpty()) {
            return null;
        }

        return t.get();
    }

    // TODO
    public List<Transaction> findByUserId(long id) {
        return null;
    }

    // Update

    // Delete
}

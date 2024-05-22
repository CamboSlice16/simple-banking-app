package com.camdyn.simplebankingapp.domain.business;

import java.util.ArrayList;
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
public class TransactionService {

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

    public Transaction createWithdrawal(double amount, long account_from_id) {
        return transactionRepo.save(new Transaction(Transaction.TransactionType.WITHDRAWAL, amount, account_from_id));
    }

    public List<Transaction> createTransfer(double amount, long account_to_id, long account_from_id) {
        List<Transaction> t = new ArrayList<>();
        t.add(createDeposit(amount, account_to_id));
        t.add(createWithdrawal(-amount, account_from_id));
        return t;
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

    public List<Transaction> findByAccountId(long id) {
        return transactionRepo.findByAccountId(id);
    }

    // Update

    // Delete

    public void deleteAll() {
        try {
            transactionRepo.deleteAll();
        } catch (Exception e) {
            // e.printStackTrace();
        }
    }

    public void deleteTransaction(long id) {
        try {
            transactionRepo.deleteById(id);
        } catch (Exception e) {
            // e.printStachTrace();
        }
    }
}

package com.camdyn.simplebankingapp.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.camdyn.simplebankingapp.domain.datastructure.Account;
import com.camdyn.simplebankingapp.domain.datastructure.Transaction;
import com.camdyn.simplebankingapp.domain.repo.AccountRepo;
import com.camdyn.simplebankingapp.domain.repo.TransactionRepo;




@RestController
@CrossOrigin
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private final TransactionRepo transactionRepo;

    @Autowired
    private final AccountRepo accountRepo;

    public TransactionController(TransactionRepo transactionRepo, AccountRepo accountRepo) {
        this.transactionRepo = transactionRepo;
        this.accountRepo = accountRepo;
    }

    @PostMapping("/deposit")
    public ResponseEntity postDeposit(@RequestBody Transaction transaction) throws Exception {
        // Does the account exist?
        Optional<Account> account = accountRepo.findById(transaction.getAccountId());
        if (account.isEmpty()) {
            throw new Exception("Account does not exist!");
        }

        // Modify/submit deposit
        transaction.setType(Transaction.TransactionType.DEPOSIT.label);
        transactionRepo.save(transaction);

        // Change balance in existing account
        account.get().addBalance(transaction.getAmount());
        accountRepo.save(account.get());

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/withdrawal")
    public ResponseEntity postWithdrawal(@RequestBody Transaction transaction) throws Exception {
        // Does the account exist?
        Optional<Account> account = accountRepo.findById(transaction.getAccountId());
        if (account.isEmpty()) {
            throw new Exception("Account does not exist!");
        }

        // Modify/submit deposit
        transaction.setType(Transaction.TransactionType.WITHDRAWAL.label);
        transactionRepo.save(transaction);

        // Change balance in existing account
        account.get().subtractBalance(transaction.getAmount());
        accountRepo.save(account.get());

        return ResponseEntity.ok(HttpStatus.OK);
    }
    
}

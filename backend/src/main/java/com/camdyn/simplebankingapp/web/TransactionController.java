package com.camdyn.simplebankingapp.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.camdyn.simplebankingapp.usecase.Transfer;

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
    public ResponseEntity<Account> postDeposit(@RequestBody Transaction transaction) throws Exception {
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

        return ResponseEntity.ok().build();
    }

    @PostMapping("/withdrawal")
    public ResponseEntity<Account> postWithdrawal(@RequestBody Transaction transaction) throws Exception {
        // Does the account exist?
        Optional<Account> account = accountRepo.findById(transaction.getAccountId());
        if (account.isEmpty()) {
            throw new Exception("Account does not exist!");
        }

        // Modify/submit withdrawal
        transaction.setType(Transaction.TransactionType.WITHDRAWAL.label);
        transactionRepo.save(transaction);

        // Change balance in existing account
        account.get().subtractBalance(transaction.getAmount());
        accountRepo.save(account.get());

        return ResponseEntity.ok().build();
    }

    @PostMapping("/transfer")
    public ResponseEntity<Account> postTransfer(@RequestBody Transfer transfer) throws Exception {
        // Do the accounts exist?
        Optional<Account> account_to = accountRepo.findById(transfer.getAccountTo());
        if (account_to.isEmpty()) {
            throw new Exception("Account To does not exist!");
        }

        Optional<Account> account_from = accountRepo.findById(transfer.getAccountFrom());
        if (account_from.isEmpty()) {
            throw new Exception("Account From does not exist!");
        }

        // Deposit
        Transaction deposit = new Transaction(
            Transaction.TransactionType.DEPOSIT,
            transfer.getAmount(),
            transfer.getAccountTo(),
            "Transfer from Account " + transfer.getAccountFrom());
        transactionRepo.save(deposit);

        account_to.get().addBalance(transfer.getAmount());
        accountRepo.save(account_to.get());

        // Withdrawal
        Transaction withdrawal = new Transaction(
            Transaction.TransactionType.WITHDRAWAL,
            transfer.getAmount(),
            transfer.getAccountFrom(),
            "Transfer to Account " + transfer.getAccountTo());
        transactionRepo.save(withdrawal);

        account_from.get().subtractBalance(transfer.getAmount());
        accountRepo.save(account_from.get());

        return ResponseEntity.ok().build();
    }
    
}

package com.camdyn.simplebankingapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    // public ResponseEntity<Transaction> postDeposit(@RequestBody Transaction transaction) {
    @PostMapping("/deposit")
    public ResponseEntity postDeposit(@RequestBody Transaction transaction) {
        transaction.setType(Transaction.TransactionType.DEPOSIT.label);
        transactionRepo.save(transaction);
        // TODO: Add money to account balance
        // URI nextUri = ServletUriComponentsBuilder.fromCurrentRequest()
        //                                          .path("/{id}")
        //                                          .buildAndExpand(transaction.getId())
        //                                          .toUri();
        // return ResponseEntity.created(nextUri).build();
        return ResponseEntity.ok(HttpStatus.OK);
    }
    
}

package com.camdyn.simplebankingapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.camdyn.simplebankingapp.domain.repo.TransactionRepo;


@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionRepo transactionRepo;

    public TransactionController(TransactionRepo transactionRepo) {
        super();
        this.transactionRepo = transactionRepo;
    }

    // @PostMapping("/transactions/${id}")
    // public List<Transaction> getTransactionsForId(@RequestParam Long id) {
    //     return null;
    // }

}

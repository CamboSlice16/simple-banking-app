package com.camdyn.simplebankingapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.camdyn.simplebankingapp.domain.business.TransactionService;
import com.camdyn.simplebankingapp.domain.datastructure.Transaction;



@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/transactions")
    public String postMethodName(@RequestParam long user_id) {
        //TODO: process POST request
        
        return null;
    }
    

    @GetMapping("/transactions/${id}")
    public Transaction getTransaction(@PathVariable Long id) {
        return transactionService.findById(id);
    }

}

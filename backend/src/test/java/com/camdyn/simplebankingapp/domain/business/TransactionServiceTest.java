package com.camdyn.simplebankingapp.domain.business;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.camdyn.simplebankingapp.domain.datastructure.Transaction;

@SpringBootTest
public class TransactionServiceTest {

    @Autowired
    private TransactionService transactionService;

    @Test
    public void testCrudServices() {

        List<Transaction> test = new ArrayList<>();

        transactionService.deleteAll();

        test.add(transactionService.createDeposit(100.00, 1));
        test.addAll(transactionService.createTransfer(100.00, 1, 2));
        test.add(transactionService.createWithdrawal(100.00, 2));

        List<Transaction> db = transactionService.findAllTransactions();

        assertEquals(db.size(), test.size());
    }
}

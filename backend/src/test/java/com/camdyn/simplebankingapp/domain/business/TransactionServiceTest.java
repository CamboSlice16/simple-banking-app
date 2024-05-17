package com.camdyn.simplebankingapp.domain.business;

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
    public void testFindAllTransactions() {
        List<Transaction> transactions = transactionService.findAllTransactions();

        assertEquals(transactions.size(), 3);
    }
}

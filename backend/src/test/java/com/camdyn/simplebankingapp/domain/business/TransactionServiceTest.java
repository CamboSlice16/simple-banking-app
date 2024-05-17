package com.camdyn.simplebankingapp.domain.business;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.camdyn.simplebankingapp.domain.datastructure.Transaction;
import com.camdyn.simplebankingapp.domain.repo.AccountRepo;
import com.camdyn.simplebankingapp.domain.repo.TransactionRepo;
import com.camdyn.simplebankingapp.domain.repo.UserRepo;

@SpringBootTest
public class TransactionServiceTest {

    @Autowired
    private TransactionRepo transactionRepo;

    @Autowired
    private AccountRepo accountRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private TransactionService transactionService;

    @Test
    public void testFindAllTransactions() {
        List<Transaction> transactions = transactionService.findAllTransactions();

        assertEquals(transactions.size(), 3);
    }
}

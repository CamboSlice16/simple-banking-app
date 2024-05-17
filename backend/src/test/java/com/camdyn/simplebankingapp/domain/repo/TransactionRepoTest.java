package com.camdyn.simplebankingapp.domain.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes=TransactionRepoTest.class)
public class TransactionRepoTest {

    @Autowired
    private TransactionRepo repository;

//    private Transaction mockTransaction() {
//        Transaction transaction = new Transaction();
//        transaction.setId((long) 1);
//        transaction.setType("transfer");
//        transaction.setAmount(500.00);
//        transaction.setAccountToId((long) 101);
//        transaction.setAccountFromId((long) 102);
//
//        return transaction;
//    }
//
//    @Test
//    public void testTransactionSave() {
//        Transaction transaction = mockTransaction();
//        repository.save(transaction);
//
//        Transaction dbTransaction = repository.getTransactionById(transaction.getId());
//
//        assertEquals(dbTransaction.getId(), 1);
//        assertEquals(dbTransaction.getType(), "transfer");
//        assertEquals(dbTransaction.getAmount(), 500.00);
//        assertEquals(dbTransaction.getAccountToId(), (long) 101);
//        assertEquals(dbTransaction.getAccountFromId(), (long) 102);
//    }

//    @Test
//    public void testTransactionFindAll() {
//        List<Transaction> transactions = repository.findAll();
//
//        assertEquals(transactions.size(), 3);
//    }
}
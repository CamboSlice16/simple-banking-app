package com.camdyn.simplebankingapp.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.camdyn.simplebankingapp.datastructure.Transaction;

@DataJpaTest
public class TransactionRepoImplTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private TransactionRepo repository;

    @Test
    public void testTransactionSave() {
        Transaction transaction = new Transaction();
        transaction.setType("transfer");
        transaction.setAmount(500.00);
        transaction.setAccountToId((long) 101);
        transaction.setAccountFromId((long) 102);
        
        entityManager.persist(transaction);

        Transaction dbTransaction = repository.getTransactionById(transaction.getId());

        assertEquals(dbTransaction.getId(), 1);
        assertEquals(dbTransaction.getType(), "transfer");
        assertEquals(dbTransaction.getAmount(), 500.00);
        assertEquals(dbTransaction.getAccountToId(), (long) 101);
        assertEquals(dbTransaction.getAccountFromId(), (long) 102);
    }
}

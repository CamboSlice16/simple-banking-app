package com.camdyn.simplebankingapp.domain.repo;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TransactionRepoImplTest {

//    @Mock
//    private TransactionRepoImpl repository;
//
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
}

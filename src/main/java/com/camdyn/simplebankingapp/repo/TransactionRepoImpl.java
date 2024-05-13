package com.camdyn.simplebankingapp.repo;

import com.camdyn.simplebankingapp.datastructure.Transaction;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

public class TransactionRepoImpl implements TransactionRepo {

    private EntityManager entityManager;

    public TransactionRepoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public Transaction save(Transaction transaction) {
        try {
            if (transaction.getId() == null) {
                entityManager.persist(transaction);
            } else {
                transaction = entityManager.merge(transaction);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return transaction;
    }

    @Override
    public Transaction getTransactionById(Long id) {
        Transaction transaction = entityManager.find(Transaction.class, id);
        return transaction;
    }

    @Override
    @Transactional
    public void deleteTransaction(Transaction transaction) {
        if (entityManager.contains(transaction)) {
            entityManager.remove(transaction);
        } else {
            
        }
    }

    // List<Transaction> getTransactionsByUsername(String username);
}

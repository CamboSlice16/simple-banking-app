package com.camdyn.simplebankingapp.domain.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.camdyn.simplebankingapp.domain.datastructure.Transaction;

/**
 * Interface extending JpaRepository for Transaction entity
 * @author camdyn
 */

public interface TransactionRepo extends JpaRepository<Transaction, Long> {
    
}
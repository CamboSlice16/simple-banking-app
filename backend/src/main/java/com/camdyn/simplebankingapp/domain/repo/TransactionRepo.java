package com.camdyn.simplebankingapp.domain.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.camdyn.simplebankingapp.domain.datastructure.Transaction;

/**
 * Interface extending JpaRepository for Transaction entity
 * @author camdyn
 */

// @RepositoryRestResource(path="transaction", collectionResourceRel="transaction")
public interface TransactionRepo extends JpaRepository<Transaction, Long> {

    List<Transaction> findByAccountId(long id);

}

package com.camdyn.simplebankingapp.domain.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.camdyn.simplebankingapp.domain.datastructure.Account;

@Component
public interface AccountRepo extends JpaRepository<Account, Long> {
    
    List<Account> findByOwner(long ownerId);
}

package com.camdyn.simplebankingapp.domain.repo;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.camdyn.simplebankingapp.domain.datastructure.Account;

@SpringBootTest
public class AccountRepoTest {
    
    @Autowired
    private AccountRepo accountRepo;

    @Test
    public void getAccountsByOwner() {
        List<Account> accounts = accountRepo.findByOwner(1);
        assertEquals(3, accounts.size());
    }
}

package com.camdyn.simplebankingapp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.camdyn.simplebankingapp.domain.datastructure.Account;
import com.camdyn.simplebankingapp.domain.datastructure.Transaction;
import com.camdyn.simplebankingapp.domain.datastructure.User;
import com.camdyn.simplebankingapp.domain.repo.AccountRepo;
import com.camdyn.simplebankingapp.domain.repo.TransactionRepo;
import com.camdyn.simplebankingapp.domain.repo.UserRepo;

/**
 * Endpoint for Account Entity
 * @author camdyn
 */

@RestController
@CrossOrigin
@RequestMapping("/accounts")
public class AccountsController {

    @Autowired
    private final AccountRepo accountRepo;

    @Autowired
    private final UserRepo userRepo;

    @Autowired
    private final TransactionRepo transactionRepo;

    public AccountsController(AccountRepo accountRepo, UserRepo userRepo, TransactionRepo transactionRepo) {
        this.accountRepo = accountRepo;
        this.userRepo = userRepo;
        this.transactionRepo = transactionRepo;
    }

    @GetMapping("/{username}")
    public List<Account> getAccounts(@PathVariable String username) throws Exception {
        long id = getIdForUser(username);

        return accountRepo.findByOwner(id);
    }

    private long getIdForUser(String username) throws Exception {
        try {
            User user = userRepo.findByUsername(username);
            return user.getId();
        } catch (Exception e) {
            throw new Exception("User not found!", e);
        }
    }
    
    @GetMapping("/accounts/{id}")
    public List<Transaction> getTransactions(@PathVariable long id) {
        return transactionRepo.findByAccountId(id);
    }
    
}

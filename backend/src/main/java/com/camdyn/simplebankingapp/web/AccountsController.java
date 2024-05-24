package com.camdyn.simplebankingapp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.camdyn.simplebankingapp.domain.datastructure.Account;
import com.camdyn.simplebankingapp.domain.datastructure.User;
import com.camdyn.simplebankingapp.domain.repo.AccountRepo;
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

    public AccountsController(AccountRepo accountRepo, UserRepo userRepo) {
        this.accountRepo = accountRepo;
        this.userRepo = userRepo;
    }

    @GetMapping("/accounts/${username}")
    public List<Account> postMethodName(@PathVariable String username) {
        long id = getIdForUser(username);

        return accountRepo.findByOwner(id);
    }

    private long getIdForUser(String username) {
        User user = userRepo.findByUsername(username);
        if (user  == null) {
            // TODO: Throw exception
        }

        return user.getId();
    }
    
    
}

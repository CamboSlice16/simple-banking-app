package com.camdyn.simplebankingapp.domain.business;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.camdyn.simplebankingapp.domain.datastructure.Account;
import com.camdyn.simplebankingapp.domain.repo.AccountRepo;

/**
 * Business Tier class for Account Library
 * @author camdyn
 */

@Repository
public class AccountService {
    private final AccountRepo accountRepo;

    public AccountService(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }

    // Create

    public Account CreateEmptyAccount(String type, long owner) {
        return accountRepo.save(new Account(type, owner));
    }

    public Account CreateAccount(String type, float balance, long owner) {
        return accountRepo.save(new Account(type, balance, owner));
    }

    // Read

    public Account FindById(long id) {
        try {
            Optional<Account> a = accountRepo.findById(id);
            return a.get();
        } catch (IllegalArgumentException i) {
            System.out.println("[AccountService.FindById()] Entity doesn't exist!");
            return null;
        } catch (Exception e) {
            // e.printStackTrace();
            return null;
        }
    }

    // Update

    public void subtractBalance(long id, float diff) {
        try {
            Account a = FindById(id);
            a.subtractBalance(diff);
            accountRepo.save(a);
        } catch (Exception e) {
            // e.printStackTrace();
        }
    }

    public void addBalance(long id, float diff) {
        try {
            Account a = FindById(id);
            a.addBalance(diff);
            accountRepo.save(a);
        } catch (Exception e) {
            // e.printStackTrace();
        }
    }

    // Delete

    public void deleteAccount(long id) {
        try {
            accountRepo.deleteById(id);
        } catch (Exception e) {
            // e.printStackTrace();
        }
    }
}

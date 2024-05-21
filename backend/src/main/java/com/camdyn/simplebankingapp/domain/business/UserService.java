package com.camdyn.simplebankingapp.domain.business;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.camdyn.simplebankingapp.domain.datastructure.User;
import com.camdyn.simplebankingapp.domain.repo.UserRepo;

/**
 * Business Tier class for User Library
 * @author camdyn
 */

@Repository
public class UserService {
    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    // Create

    public User CreateUser(String username, String password, String firstName, String lastName) {
        return userRepo.save(new User(username, password, firstName, lastName));
    }

    // Read

    public User FindById(long id) {
        Optional<User> u = userRepo.findById(id);
        if (u.isEmpty()) {
            return null;
        }

        return u.get();
    }

    // Update

    // Delete

    public void deleteUser(long id) {
        try {
            userRepo.deleteById(id);
        } catch (Exception e) {
            // e.printStackTrace();
        }
    }
}

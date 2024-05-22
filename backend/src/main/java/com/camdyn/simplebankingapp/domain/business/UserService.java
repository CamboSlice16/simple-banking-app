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
        try {
            Optional<User> u = userRepo.findById(id);
            return u.get();
        } catch (IllegalArgumentException i) {
            System.out.println("[UserService.FindById()] Entity doesn't exist!");
            return null;
        } catch (Exception e) {
            // e.printStrackTrace();
            return null;
        }
    }

    // Update

    public void changeUsername(long id, String username) {
        try {
            // TODO: Verify Username is unique!
            User u = FindById(id);
            u.setUsername(username);
            userRepo.save(u);
        } catch (Exception e) {
            // e.printStrackTrace();
        }
    }

    public void changePassword(long id, String password) {
        try {
            User u = FindById(id);
            u.setPassword(password);
            userRepo.save(u);
        } catch (Exception e) {
            // e.printStrackTrace();
        }
    }

    // Delete

    public void deleteUser(long id) {
        try {
            userRepo.deleteById(id);
        } catch (Exception e) {
            // e.printStackTrace();
        }
    }
}

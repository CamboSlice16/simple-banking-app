package com.camdyn.simplebankingapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.camdyn.simplebankingapp.domain.repo.UserRepo;


@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private final UserRepo userRepo;

    public UserController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    // @GetMapping("/${username}")
    // public User getUserCredentials(@PathVariable String username) {
    //     try {
    //         User user = userRepo.findByUsername(username);
    //         return user;
    //     } catch (Exception e) {
    //         throw e;
    //     }
    // }

    // @DeleteMapping("/${id}")
    // public ResponseEntity<User> deleteUser(@PathVariable long id) {
    //     userRepo.deleteById(id);
    //     return ResponseEntity.ok().build();
    // }
    
}

package com.camdyn.simplebankingapp.domain.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.camdyn.simplebankingapp.domain.datastructure.User;

@Component
public interface UserRepo extends JpaRepository<User, Long> {
    
    User findByUsername(String username);
}
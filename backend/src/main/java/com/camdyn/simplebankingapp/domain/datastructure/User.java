package com.camdyn.simplebankingapp.domain.datastructure;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User {

    @Id
    @Column(name="user_id")
    private Long userId;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Override
    public String toString() {
        return "Account [User ID: " + userId + "Username: " + username + "Password: " + protectPassword() + ", First: " + firstName + "Last: " + lastName + "]";
    }

    // Really just to get rid of warning flags in VSCode...
    private String protectPassword() {
        return "*".repeat(password.length());
    }
}

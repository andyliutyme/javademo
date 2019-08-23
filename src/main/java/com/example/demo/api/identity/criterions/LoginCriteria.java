package com.example.demo.api.identity.criterions;

import lombok.Getter;

@Getter
public class LoginCriteria {
    private String username;
    private String password;

    public LoginCriteria(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

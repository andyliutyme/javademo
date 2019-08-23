package com.example.demo.api.identity.criterions;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RegisterUserCriteria {
    private String username;
    private String password;
    private String identityNumber;
    private String firstName;
    private String surname;

    public RegisterUserCriteria(String username, String password, String identityNumber, String firstName, String surname) {
        this.username = username;
        this.password = password;
        this.identityNumber = identityNumber;
        this.firstName = firstName;
        this.surname = surname;
    }
}

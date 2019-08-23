package com.example.demo.data.anemics.identity;

import com.example.demo.data.anemics.BaseAnemic;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@NoArgsConstructor
@Entity
@Table(name="Users")
public class UserAnemic extends BaseAnemic {
    //region Properties
    private String username;
    private String password;
    private String identityNumber;
    private String firstName;
    private String surname;
    //endregion

    //region Methods
    public static UserAnemic createEntity(String username, String password, String identityNumber, String firstName, String surname)
    {
        var newUser = new UserAnemic();
        newUser.initialize(newUser.getClass().toString());
        newUser.username = username;
        newUser.password = password;
        newUser.identityNumber = identityNumber;
        newUser.firstName = firstName;
        newUser.surname = surname;
        return newUser;
    }
    //endregion
}

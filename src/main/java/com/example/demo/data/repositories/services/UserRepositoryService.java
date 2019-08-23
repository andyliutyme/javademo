package com.example.demo.data.repositories.services;

import com.example.demo.data.anemics.identity.UserAnemic;
import com.example.demo.data.repositories.interfaces.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRepositoryService {
    @Autowired
    private IUserRepository repository;

    public List<UserAnemic> getUsers() {
        return this.repository.findAll();
    }

    public void saveChanges(UserAnemic user)
    {
        this.repository.save(user);
    }

    public UserAnemic getUserByIdentityNumber(String identityNumber)
    {
        var users = this.getUsers();
        if (users == null || users.isEmpty())
        {
            return null;
        }

        for (var user: users)
        {
            if (user.getIdentityNumber().equals(identityNumber))
            {
                return user;
            }
        }

        return null;
    }

    public UserAnemic getUserByUsername(String username)
    {
        var users = this.getUsers();
        if (users == null || users.isEmpty())
        {
            return null;
        }

        for (var user: users)
        {
            if (user.getUsername().equals(username))
            {
                return user;
            }
        }

        return null;
    }
}

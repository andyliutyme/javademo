package com.example.demo.api.identity.commands;

import com.example.demo.api.identity.criterions.LoginCriteria;
import com.example.demo.integrations.internal.interfaces.commands.ICommand;
import lombok.Getter;

@Getter
public class Login implements ICommand {
    private LoginCriteria criteria;

    public Login(LoginCriteria criteria) {
        this.criteria = criteria;
    }

    @Override
    public String getEventName() {
        return "Login";
    }

    @Override
    public String getEventDescription() {
        return "Login an user with username and password";
    }
}

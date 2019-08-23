package com.example.demo.api.identity.commands;

import com.example.demo.api.identity.criterions.RegisterUserCriteria;
import com.example.demo.integrations.internal.interfaces.commands.ICommand;
import lombok.Getter;

public class RegisterUser implements ICommand {
    //region Properties
    @Getter
    private RegisterUserCriteria criteria;
    //endregion

    //region Constructor
    public RegisterUser(RegisterUserCriteria criteria) {
        this.criteria = criteria;
    }
    //endregion

    //region Overrides
    @Override
    public String getEventName() {
        return "Register user";
    }

    @Override
    public String getEventDescription() {
        return "Register an user based on username and password";
    }
    //endregion
}

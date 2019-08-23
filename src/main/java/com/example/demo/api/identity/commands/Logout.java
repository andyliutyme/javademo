package com.example.demo.api.identity.commands;

import com.example.demo.integrations.internal.interfaces.commands.ICommand;
import lombok.Getter;

@Getter
public class Logout implements ICommand {
    private String sessionId;

    public Logout(String sessionId) {
        this.sessionId = sessionId;
    }

    @Override
    public String getEventName() {
        return "Logout";
    }

    @Override
    public String getEventDescription() {
        return "Logs an user out";
    }
}

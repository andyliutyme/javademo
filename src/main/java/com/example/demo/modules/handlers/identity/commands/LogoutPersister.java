package com.example.demo.modules.handlers.identity.commands;

import com.example.demo.api.identity.commands.Logout;
import com.example.demo.data.repositories.services.SessionRepositoryService;
import com.example.demo.modules.handlers.BasePersister;

public class LogoutPersister extends BasePersister<Logout> {
    private SessionRepositoryService sessionRepositoryService;

    public LogoutPersister(SessionRepositoryService sessionRepositoryService)
    {
        this.sessionRepositoryService = sessionRepositoryService;
    }

    @Override
    protected void handle() {
        try {
            if (this.command.getSessionId().equals("")) {
                this.error("Invalid session");

                return;
            }

            var existingSession = this.sessionRepositoryService.getSessionById(this.command.getSessionId());
            if (!existingSession.isValid()) {
                this.error("Invalid session");

                return;
            }
            existingSession.invalidate("User logged out");
            this.sessionRepositoryService.saveChanges(existingSession);
        } catch (Exception ex) {
            this.error(ex.getMessage());
        }
    }
}

package com.example.demo.modules.handlers.identity.commands;

import com.example.demo.api.identity.commands.Login;
import com.example.demo.data.anemics.session.SessionAnemic;
import com.example.demo.data.repositories.services.SessionRepositoryService;
import com.example.demo.data.repositories.services.UserRepositoryService;
import com.example.demo.modules.handlers.BasePersister;

public class LoginPersister extends BasePersister<Login> {
    private UserRepositoryService userRepositoryService;
    private SessionRepositoryService sessionRepositoryService;

    public LoginPersister(UserRepositoryService userRepositoryService, SessionRepositoryService sessionRepositoryService)
    {
        this.userRepositoryService = userRepositoryService;
        this.sessionRepositoryService = sessionRepositoryService;
    }

    @Override
    protected void handle() {
        try {
            if (this.command.getCriteria() == null ||
            this.command.getCriteria().getUsername().equals("") ||
            this.command.getCriteria().getPassword().equals("")) {
                this.error("Criteria is null");

                return;
            }

            var existingUser = this.userRepositoryService.getUserByUsername(this.command.getCriteria().getUsername());
            if (existingUser == null)
            {
                this.error("Invalid credentials");

                return;
            }

            var existingSession = this.sessionRepositoryService.getSessionByUserId(existingUser.getId());
            if (existingSession != null && existingSession.isValid())
            {
                this.error("Already logged in");

                return;
            }

            var newSession = SessionAnemic.createEntity(existingUser);

            sessionRepositoryService.saveChanges(newSession);

            this.succeed(newSession.getId());

        } catch (Exception ex) {
            this.error(ex.getMessage());
        }
    }
}

package com.example.demo.modules.handlers.identity.commands;

import com.example.demo.api.identity.commands.RegisterUser;
import com.example.demo.data.anemics.identity.UserAnemic;
import com.example.demo.data.repositories.services.UserRepositoryService;
import com.example.demo.modules.handlers.BasePersister;

public class UserPersister extends BasePersister<RegisterUser> {
    private UserRepositoryService userRepositoryService;

    public UserPersister(UserRepositoryService userRepositoryService) {
        this.userRepositoryService = userRepositoryService;
    }

    @Override
    protected void handle() {
        if (this.command.getCriteria() == null) {
            this.error("Criteria is null");

            return;
        }

        var user = this.userRepositoryService.getUserByIdentityNumber(this.command.getCriteria().getIdentityNumber());
        if (user != null)
        {
            this.error("User already exists");

            return;
        }

        var newUser = UserAnemic.createEntity(
                this.command.getCriteria().getUsername(),
                this.command.getCriteria().getPassword(),
                this.command.getCriteria().getIdentityNumber(),
                this.command.getCriteria().getFirstName(),
                this.command.getCriteria().getSurname()
        );

        this.userRepositoryService.saveChanges(newUser);

        this.succeed(newUser.getId());
    }
}

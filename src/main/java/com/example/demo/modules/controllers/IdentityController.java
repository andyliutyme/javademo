package com.example.demo.modules.controllers;

import com.example.demo.api.identity.commands.Login;
import com.example.demo.api.identity.commands.Logout;
import com.example.demo.api.identity.commands.RegisterUser;
import com.example.demo.api.identity.criterions.LoginCriteria;
import com.example.demo.api.identity.criterions.RegisterUserCriteria;
import com.example.demo.data.repositories.services.SessionRepositoryService;
import com.example.demo.data.repositories.services.UserRepositoryService;
import com.example.demo.integrations.internal.models.CommandResult;
import com.example.demo.modules.handlers.identity.commands.LoginPersister;
import com.example.demo.modules.handlers.identity.commands.LogoutPersister;
import com.example.demo.modules.handlers.identity.commands.UserPersister;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/identities/")
@Api(tags = "identity endpoints")
public class IdentityController extends BaseController {
    private UserPersister userPersister;
    private LoginPersister loginPersister;
    private LogoutPersister logoutPersister;

    public IdentityController(
            UserRepositoryService userRepositoryService,
            SessionRepositoryService sessionRepositoryService) {
        this.userPersister = new UserPersister(userRepositoryService);
        this.loginPersister = new LoginPersister(userRepositoryService, sessionRepositoryService);
        this.logoutPersister = new LogoutPersister(sessionRepositoryService);
    }

    @RequestMapping(value = "register", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(value = "Register an user", response = CommandResult.class)
    public ResponseEntity<?> registerUser(@RequestBody RegisterUserCriteria criteria) {
        try {
            if (criteria == null) {
                throw new IllegalArgumentException("Criteria is null");
            }

            var command = new RegisterUser(criteria);

            return this.generateReturnResult(this.userPersister.handle(command));
        } catch (Exception ex) {
            return this.generateReturnResult(ex);
        }
    }

    @RequestMapping(value = "login", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(value = "User login", response = CommandResult.class)
    public ResponseEntity<?> login(@RequestBody LoginCriteria criteria) {
        try {
            if (criteria == null) {
                throw new IllegalArgumentException("Criteria is null");
            }

            var command = new Login(criteria);

            return this.generateReturnResult(this.loginPersister.handle(command));
        } catch (Exception ex) {
            return this.generateReturnResult(ex);
        }
    }

    @RequestMapping(value = "logout", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(value = "User logout", response = CommandResult.class)
    public ResponseEntity<?> logout() {
        try {
            var command = new Logout(this.getSessionid());

            return this.generateReturnResult(this.logoutPersister.handle(command));
        } catch (Exception ex) {
            return this.generateReturnResult(ex);
        }
    }
}

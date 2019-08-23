package com.example.demo.modules.handlers;

import com.example.demo.integrations.internal.interfaces.commands.ICommand;
import com.example.demo.integrations.internal.interfaces.commands.ICommandHandler;
import com.example.demo.integrations.internal.interfaces.commands.ICommandResult;
import com.example.demo.integrations.internal.models.CommandResult;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public abstract class BasePersister<T extends ICommand> implements ICommandHandler<T> {
    protected T command;
    @Getter
    private CommandResult commandResult;

    @Override
    public ICommandResult handle(T command) {
        this.commandResult = new CommandResult();
        try {
            this.command = command;
            if (this.command == null) {
                this.commandResult.fail(new IllegalArgumentException());

                return this.commandResult;
            }

            this.handle();
        } catch (Exception ex) {
            this.error(ex.getMessage());
        }

        return this.commandResult;
    }

    protected abstract void handle();

    protected void succeed(String recordId) {
        if (recordId != null && !recordId.equals("")) {
            this.commandResult.setRecordId(recordId);
        }
    }

    protected void error(String errorMessage) {
        this.commandResult.fail(errorMessage);
    }

    protected void error(ICommandResult commandResult) {
        if (commandResult.isSuccess()) {
            throw new IllegalArgumentException("Can not extract errors from a successful command");
        }

        if (commandResult instanceof CommandResult) {
            this.commandResult = (CommandResult) commandResult;
        } else {
            this.commandResult.fail("Unhandled result");
        }
    }
}

package com.example.demo.integrations.internal.interfaces.commands;

public interface ICommandHandler<TCommand extends ICommand> {
    ICommandResult handle(TCommand command);
}

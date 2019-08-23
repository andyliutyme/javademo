package com.example.demo.integrations.internal.models;

import com.example.demo.integrations.internal.interfaces.commands.ICommandResult;
import lombok.Getter;

import java.util.ArrayList;
import java.util.UUID;

public class CommandResult implements ICommandResult {
    private boolean success;
    private ArrayList<String> errors;
    @Getter
    private String recordId;

    public CommandResult()
    {
        this.success = true;
        this.errors = null;
        this.recordId = "";
    }

    public CommandResult(boolean success, String recordId, ArrayList<String> errors)
    {
        this.success = success;
        this.errors = errors;
        this.recordId = recordId;
    }

    @Override
    public boolean isSuccess() {
        return this.success;
    }

    public ArrayList<String> getErrors()
    {
        return this.errors;
    }

    public void fail(Exception ex)
    {
        this.fail(ex.getMessage());
    }

    public void fail(String errorMessage)
    {
        this.success = false;

        if (this.errors == null || errors.size() < 1) {
            this.errors = new ArrayList<String>();
            errors.add(errorMessage);
        }
        else {
            if (!this.errors.contains(errorMessage)) {
                this.errors.add(errorMessage);
            }
        }
    }

    public void setRecordId(String recordId)
    {
        this.recordId = recordId;
    }

    public void setRecordId(UUID recordId)
    {
        this.recordId = recordId.toString();
    }

    public void setRecordId(int recordId)
    {
        this.recordId = Integer.toString(recordId);
    }
}

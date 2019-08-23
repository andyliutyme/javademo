package com.example.demo.api.document.commands;

import com.example.demo.api.document.criterions.DocumentCriteria;
import com.example.demo.integrations.internal.interfaces.commands.ICommand;
import lombok.Getter;

@Getter
public class CreateDocument implements ICommand {
    private String sessionId;
    private DocumentCriteria criteria;

    public CreateDocument(String sessionId, DocumentCriteria criteria) {
        this.sessionId = sessionId;
        this.criteria = criteria;
    }

    @Override
    public String getEventName() {
        return "Upload document";
    }

    @Override
    public String getEventDescription() {
        return "Upload document";
    }
}

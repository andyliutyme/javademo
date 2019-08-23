package com.example.demo.api.document.queries;

import com.example.demo.integrations.internal.interfaces.queries.IQuery;
import lombok.Getter;

@Getter
public class GetDocumentType implements IQuery {
    private String sessionId;
    private String id;

    public GetDocumentType(String sessionId, String id) {
        this.sessionId = sessionId;
        this.id = id;
    }

    @Override
    public String getEventName() {
        return "Get document type";
    }

    @Override
    public String getEventDescription() {
        return "Get all document type with rulesets";
    }
}

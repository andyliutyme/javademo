package com.example.demo.api.document.queries;

import com.example.demo.integrations.internal.interfaces.queries.IQuery;
import lombok.Getter;

@Getter
public class GetDocumentTypes implements IQuery {
    private String sessionId;

    public GetDocumentTypes(String sessionId) {
        this.sessionId = sessionId;
    }

    @Override
    public String getEventName() {
        return "Get document types";
    }

    @Override
    public String getEventDescription() {
        return "Get all document types";
    }
}

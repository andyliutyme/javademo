package com.example.demo.api.document.criterions;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DocumentCriteria {
    private String sessionId;
    private String documentTypeId;
    private DocumentPageCriteria[] pages;

    public DocumentCriteria(String sessionId, String documentTypeId, DocumentPageCriteria[] pages) {
        this.sessionId = sessionId;
        this.documentTypeId = documentTypeId;
        this.pages = pages;
    }
}

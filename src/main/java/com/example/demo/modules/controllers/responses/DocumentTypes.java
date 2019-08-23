package com.example.demo.modules.controllers.responses;

import com.example.demo.api.document.viewmodels.DocumentType;
import com.example.demo.integrations.internal.models.QueryResultList;

public class DocumentTypes extends QueryResultList<DocumentType> {

    public DocumentTypes(DocumentType[] items) {
        super(items);
    }

}

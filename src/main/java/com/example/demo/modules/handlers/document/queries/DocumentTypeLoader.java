package com.example.demo.modules.handlers.document.queries;

import com.example.demo.api.document.queries.GetDocumentType;
import com.example.demo.api.document.viewmodels.DocumentType;
import com.example.demo.data.anemics.document.helpers.DocumentTypeConverter;
import com.example.demo.data.repositories.services.DocumentTypeRepositoryService;
import com.example.demo.integrations.internal.interfaces.queries.IQueryHandler;

public class DocumentTypeLoader implements IQueryHandler<GetDocumentType, DocumentType> {
    private DocumentTypeRepositoryService documentTypeRepositoryService;

    public DocumentTypeLoader(DocumentTypeRepositoryService documentTypeRepositoryService) {
        this.documentTypeRepositoryService = documentTypeRepositoryService;
    }

    @Override
    public DocumentType handle(GetDocumentType query) {
        try {
            if (query == null || query.getId() == null || query.getId().equals("")) {
                return null;
            }
            var documentTypeAnemic = this.documentTypeRepositoryService.getDocumentTypeById(query.getId());
            if (documentTypeAnemic == null) {
                return null;
            }
            return DocumentTypeConverter.convertSingle(documentTypeAnemic);
        } catch (Exception ex) {
            throw ex;
        }
    }
}

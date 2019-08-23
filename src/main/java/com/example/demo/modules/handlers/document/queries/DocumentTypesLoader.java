package com.example.demo.modules.handlers.document.queries;

import com.example.demo.api.document.queries.GetDocumentTypes;
import com.example.demo.api.document.viewmodels.DocumentType;
import com.example.demo.data.anemics.document.helpers.DocumentTypeConverter;
import com.example.demo.data.repositories.services.DocumentTypeRepositoryService;
import com.example.demo.integrations.internal.interfaces.queries.IQueryHandler;
import com.example.demo.integrations.internal.models.QueryResultList;

public class DocumentTypesLoader implements IQueryHandler<GetDocumentTypes, QueryResultList<DocumentType>> {
    private DocumentTypeRepositoryService documentTypeRepositoryService;

    public DocumentTypesLoader(DocumentTypeRepositoryService documentTypeRepositoryService) {
        this.documentTypeRepositoryService = documentTypeRepositoryService;
    }
    @Override
    public QueryResultList<DocumentType> handle(GetDocumentTypes query) {
        try {
            if (query == null) {
                return null;
            }
            var documentTypeAnemics = this.documentTypeRepositoryService.getDocumentTypes();
            if (documentTypeAnemics == null) {
                return null;
            }
            return new QueryResultList<>(DocumentTypeConverter.convertMany(documentTypeAnemics));
        } catch (Exception ex) {
            throw ex;
        }
    }
}
package com.example.demo.modules.handlers.document.commands;

import com.example.demo.api.document.commands.CreateDocument;
import com.example.demo.api.document.criterions.DocumentPageCriteria;
import com.example.demo.data.anemics.document.DocumentAnemic;
import com.example.demo.data.anemics.document.DocumentPageAnemic;
import com.example.demo.data.anemics.document.enums.DocumentPageType;
import com.example.demo.data.anemics.identity.UserAnemic;
import com.example.demo.data.repositories.services.DocumentPageRepositoryService;
import com.example.demo.data.repositories.services.DocumentRepositoryService;
import com.example.demo.data.repositories.services.DocumentTypeRepositoryService;
import com.example.demo.modules.handlers.BasePersister;

public class DocumentPersister extends BasePersister<CreateDocument> {
    private DocumentRepositoryService documentRepositoryService;
    private DocumentTypeRepositoryService documentTypeRepositoryService;
    private DocumentPageRepositoryService documentPageRepositoryService;

    private DocumentPersister(
            DocumentRepositoryService documentRepositoryService,
            DocumentTypeRepositoryService documentTypeRepositoryService,
            DocumentPageRepositoryService documentPageRepositoryService) {
        this.documentRepositoryService = documentRepositoryService;
        this.documentTypeRepositoryService = documentTypeRepositoryService;
        this.documentPageRepositoryService = documentPageRepositoryService;
    }

    @Override
    protected void handle() {
        try {
            if (this.command.getCriteria() == null) {
                this.error("Criteria is null");

                return;
            }

            var documentType = this.documentTypeRepositoryService.getDocumentTypeById(this.command.getCriteria().getDocumentTypeId());
            if (documentType == null) {
                this.error("Document type is not found");

                return;
            }
            // TODO: rule set checks

            // TODO: load user from session

            // TODO: create new document container
            for (var page: this.command.getCriteria().getPages()) {
                // TODO: duplication checks
                // TODO: convert page
            }

        } catch (Exception ex) {
            throw ex;
        }
    }

    private DocumentPageAnemic convertSingle(DocumentAnemic document, UserAnemic user, DocumentPageCriteria pageCriteria, int pageNumber, DocumentPageType type) throws Exception {
        return DocumentPageAnemic.createEntity(document, user, pageCriteria.getFileName(), pageCriteria.getContent().readAllBytes(), pageNumber, type);
    }
}

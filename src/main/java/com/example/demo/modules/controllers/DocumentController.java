package com.example.demo.modules.controllers;

import com.example.demo.api.document.commands.CreateDocument;
import com.example.demo.api.document.criterions.DocumentCriteria;
import com.example.demo.api.document.criterions.DocumentPageCriteria;
import com.example.demo.api.document.criterions.UploadFileCriteria;
import com.example.demo.api.document.queries.GetDocumentType;
import com.example.demo.api.document.queries.GetDocumentTypes;
import com.example.demo.api.document.viewmodels.DocumentType;
import com.example.demo.data.repositories.services.DocumentTypeRepositoryService;
import com.example.demo.integrations.internal.models.CommandResult;
import com.example.demo.modules.controllers.responses.DocumentTypes;
import com.example.demo.modules.handlers.document.queries.DocumentTypeLoader;
import com.example.demo.modules.handlers.document.queries.DocumentTypesLoader;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/documents/")
@Api(tags = "document endpoints")
public class DocumentController extends BaseController {
    private DocumentTypeLoader documentTypeLoader;
    private DocumentTypesLoader documentTypesLoader;

    public DocumentController(DocumentTypeRepositoryService documentTypeRepositoryService) {
        this.documentTypeLoader = new DocumentTypeLoader(documentTypeRepositoryService);
        this.documentTypesLoader = new DocumentTypesLoader(documentTypeRepositoryService);
    }

    @RequestMapping(value = "documentType", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Retrieves a single document type by id", response = DocumentType.class)
    public ResponseEntity<?> getDocumentType(@RequestParam(value = "documentTypeId", required = true) String id) {
        try {
            if (id == null || id.equals("")) {
                throw new IllegalArgumentException("Id is null");
            }

            var query = new GetDocumentType(this.getSessionid(), id);

            return this.generateReturnResult(this.documentTypeLoader.handle(query));
        } catch (Exception ex) {
            return this.generateReturnResult(ex);
        }
    }

    @RequestMapping(value = "documentTypes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Retrieves all document types and rulesets", response = DocumentTypes.class)
    public ResponseEntity<?> getDocumentTypes() {
        try {
            var query = new GetDocumentTypes(this.getSessionid());

            return this.generateReturnResult(this.documentTypesLoader.handle(query));
        } catch (Exception ex) {
            return this.generateReturnResult(ex);
        }
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Uploads a document with one or many pages", response = CommandResult.class)
    public ResponseEntity<?> uploadDocument(@RequestBody UploadFileCriteria uploadFileCriteria) {
        try {
            var pageList = new ArrayList<DocumentPageCriteria>();
            if (uploadFileCriteria.isMultipleUpload()) {
                for (var page : uploadFileCriteria.getPages()) {
                    pageList.add(this.convertSingle(page));
                }
            } else if (uploadFileCriteria.getPage() != null) {
                pageList.add(this.convertSingle(uploadFileCriteria.getPage()));
            }

            if (pageList.isEmpty()) {
                throw new IllegalArgumentException("Unable to upload empty file");
            }

            var documentCriteria = new DocumentCriteria(
                    this.getSessionid(),
                    uploadFileCriteria.getDocumentTypeId(),
                    pageList.toArray(new DocumentPageCriteria[pageList.size()]));
            var command = new CreateDocument(this.getSessionid(), documentCriteria);

            // TODO: handler
            return null;
        } catch (Exception ex) {
            return this.generateReturnResult(ex);
        }
    }

    private DocumentPageCriteria convertSingle(MultipartFile file) throws Exception {
        return new DocumentPageCriteria(
                file.getOriginalFilename(),
                file.getSize(),
                file.getInputStream());
    }
}

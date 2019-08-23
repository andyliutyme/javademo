package com.example.demo.data.anemics.document;

import com.example.demo.data.anemics.BaseAnemic;
import com.example.demo.data.anemics.document.enums.DocumentStatus;
import com.example.demo.data.anemics.identity.UserAnemic;
import lombok.Getter;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Getter
@Entity
@Table(name = "Documents")
public class DocumentAnemic extends BaseAnemic {
    @ManyToOne
    @JoinColumn(name = "userId")
    private UserAnemic user;
    private String name;
    private String friendlyName;
    private boolean isDeleted;
    private int viewCount;
    private boolean isClassificationRequired;
    private DocumentStatus status;
    private OffsetDateTime deleteAt;
    private boolean isClassified;
    private DocumentPageAnemic[] pages;
    @OneToOne
    @JoinColumn(name = "typeId")
    private DocumentTypeAnemic type;

    public static DocumentAnemic createEntity(
            UserAnemic user,
            DocumentTypeAnemic type,
            DocumentPageAnemic[] pages) {
        var newDocument = new DocumentAnemic();
        newDocument.initialize(DocumentAnemic.class.getSimpleName());
        newDocument.user = user;
        newDocument.type = type;
        // TODO: get file extension helper
        newDocument.friendlyName = type.getName();
        newDocument.isDeleted = false;
        newDocument.viewCount = 0;
        newDocument.isClassificationRequired = type.isClassifiable();
        newDocument.status = DocumentStatus.UploadPending;
        newDocument.pages = pages;

        var pageNumber = 1;
        for (var page : pages) {
            if (pageNumber == 1) {
                newDocument.name = page.getFileName();
            }
            page.setPageNumber(pageNumber);
            page.setDocument(newDocument);
        }
        return newDocument;
    }
}

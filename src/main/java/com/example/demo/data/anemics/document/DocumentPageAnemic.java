package com.example.demo.data.anemics.document;

import com.example.demo.data.anemics.BaseAnemic;
import com.example.demo.data.anemics.document.enums.DocumentPageStatus;
import com.example.demo.data.anemics.document.enums.DocumentPageType;
import com.example.demo.data.anemics.identity.UserAnemic;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "DocumentPages")
public class DocumentPageAnemic extends BaseAnemic {
    @ManyToOne
    @JoinColumn(name = "documentId")
    private DocumentAnemic document;
    @ManyToOne
    @JoinColumn(name = "userId")
    private UserAnemic user;
    private String parentPageId;
    private String fileName;
    private byte[] content;
    private int number;
    private String remoteId;
    private boolean isDeleted;
    private String failureMessage;
    private DocumentPageType type;
    private String mimeType;
    private DocumentPageStatus status;
    // TODO: classification flags

    public static DocumentPageAnemic createEntity(
            DocumentAnemic document,
            UserAnemic user,
            String fileName,
            byte[] content,
            int number,
            DocumentPageType type) {
        var newPage = new DocumentPageAnemic();
        newPage.initialize(DocumentPageAnemic.class.getSimpleName());
        newPage.document = document;
        newPage.user = user;
        newPage.fileName = fileName;
        newPage.content = content;
        newPage.number = number;
        newPage.isDeleted = false;
        newPage.type = type;
        // TODO: get file extension helper
        newPage.status = DocumentPageStatus.UploadRequired;

        return newPage;
    }

    void setPageNumber(int number) {
        this.number = number;
    }

    void setDocument(DocumentAnemic document) {
        this.document = document;
    }
}

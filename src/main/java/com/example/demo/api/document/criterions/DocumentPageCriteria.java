package com.example.demo.api.document.criterions;

import lombok.Getter;

import java.io.InputStream;

@Getter
public class DocumentPageCriteria {
    private String fileName;
    private Long fileSize;
    private InputStream content;

    public DocumentPageCriteria(String fileName, Long fileSize, InputStream content) {
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.content = content;
    }
}

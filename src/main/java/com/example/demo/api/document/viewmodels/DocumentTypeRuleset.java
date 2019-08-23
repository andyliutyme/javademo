package com.example.demo.api.document.viewmodels;

import com.example.demo.integrations.internal.interfaces.queries.IQueryResult;
import lombok.Getter;

@Getter
public class DocumentTypeRuleset implements IQueryResult {
    private String id;
    private String name;
    private int minPages;
    private int maxPages;
    private String supportedMimeTypes;

    public DocumentTypeRuleset(String id, String name, int minPages, int maxPages, String supportedMimeTypes) {
        this.id = id;
        this.name = name;
        this.minPages = minPages;
        this.maxPages = maxPages;
        this.supportedMimeTypes = supportedMimeTypes;
    }
}

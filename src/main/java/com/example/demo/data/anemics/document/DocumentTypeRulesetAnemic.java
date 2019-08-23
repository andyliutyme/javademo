package com.example.demo.data.anemics.document;

import com.example.demo.data.anemics.BaseAnemic;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "DocumentTypeRulesets")
public class DocumentTypeRulesetAnemic extends BaseAnemic {
    @ManyToOne
    @JoinColumn(name = "documentTypeId")
    private DocumentTypeAnemic documentType;
    private String Name;
    private int maxPages;
    private int minPages;
    private String supportedMimeTypes;

    public static DocumentTypeRulesetAnemic createEntity(DocumentTypeAnemic documentType, String name, int maxPages, int minPages, String supportedMimeTypes) {
        var newDocumentRuleset = new DocumentTypeRulesetAnemic();
        newDocumentRuleset.initialize(DocumentTypeRulesetAnemic.class.getSimpleName());
        newDocumentRuleset.documentType = documentType;
        newDocumentRuleset.Name = name;
        newDocumentRuleset.maxPages = maxPages;
        newDocumentRuleset.minPages = minPages;
        newDocumentRuleset.supportedMimeTypes = supportedMimeTypes;

        return newDocumentRuleset;
    }
}

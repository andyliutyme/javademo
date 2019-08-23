package com.example.demo.api.document.viewmodels;

import com.example.demo.integrations.internal.interfaces.queries.IQueryResult;
import lombok.Getter;

@Getter
public class DocumentType implements IQueryResult {
    private String id;
    private String name;
    private String categoryName;
    private String categoryDescription;
    private boolean isClassifiable;
    private boolean isAllowedMultipleInstances;
    private int displayOrder;
    private DocumentTypeRuleset[] Rulesets;

    public DocumentType(String id, String name, String categoryName, String categoryDescription, boolean isClassifiable, boolean isAllowedMultipleInstances, int displayOrder, DocumentTypeRuleset[] rulesets) {
        this.id = id;
        this.name = name;
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
        this.isClassifiable = isClassifiable;
        this.isAllowedMultipleInstances = isAllowedMultipleInstances;
        this.displayOrder = displayOrder;
        this.Rulesets = rulesets;
    }
}

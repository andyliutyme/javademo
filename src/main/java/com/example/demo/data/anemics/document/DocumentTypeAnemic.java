package com.example.demo.data.anemics.document;

import com.example.demo.data.anemics.BaseAnemic;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "DocumentTypes")
public class DocumentTypeAnemic extends BaseAnemic {
    @ManyToOne
    @JoinColumn(name = "documentCategoryId")
    private DocumentCategoryAnemic documentCategory;
    private String name;
    private String description;
    private boolean isClassifiable;
    private boolean isAllowedMultipleInstances;
    private int displayOrder;
    @OneToMany(mappedBy = "documentType")
    private Set<DocumentTypeRulesetAnemic> rulesets;

    public static DocumentTypeAnemic createEntity(DocumentCategoryAnemic documentCategory, String name, String description, boolean isClassifiable, boolean isAllowedMultipleInstances, int displayOrder) {
        var newDocumentType = new DocumentTypeAnemic();
        newDocumentType.initialize(DocumentTypeAnemic.class.getSimpleName());
        newDocumentType.documentCategory = documentCategory;
        newDocumentType.name = name;
        newDocumentType.description = description;
        newDocumentType.isClassifiable = isClassifiable;
        newDocumentType.isAllowedMultipleInstances = isAllowedMultipleInstances;
        newDocumentType.displayOrder = displayOrder;

        return newDocumentType;
    }
}

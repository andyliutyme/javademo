package com.example.demo.data.anemics.document;

import com.example.demo.data.anemics.BaseAnemic;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "DocumentCategories")
public class DocumentCategoryAnemic extends BaseAnemic {
    private String name;
    private String description;
    @OneToMany
    private Set<DocumentTypeAnemic> documentTypes;

    public static DocumentCategoryAnemic createEntity(String name, String description) {
        var newDocumentCategory = new DocumentCategoryAnemic();
        newDocumentCategory.initialize(DocumentCategoryAnemic.class.getSimpleName());
        newDocumentCategory.name = name;
        newDocumentCategory.description = description;

        return newDocumentCategory;
    }
}

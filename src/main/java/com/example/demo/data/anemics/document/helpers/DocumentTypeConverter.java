package com.example.demo.data.anemics.document.helpers;

import com.example.demo.api.document.viewmodels.DocumentType;
import com.example.demo.data.anemics.document.DocumentTypeAnemic;

import java.util.ArrayList;
import java.util.Collection;

public class DocumentTypeConverter {
    public static DocumentType convertSingle(DocumentTypeAnemic documentTypeAnemic) {
        if (documentTypeAnemic == null || documentTypeAnemic.getDocumentCategory() == null) {
            return null;
        }
        var documentType = new DocumentType(
                documentTypeAnemic.getId(),
                documentTypeAnemic.getName(),
                documentTypeAnemic.getDocumentCategory().getName(),
                documentTypeAnemic.getDocumentCategory().getDescription(),
                documentTypeAnemic.isClassifiable(),
                documentTypeAnemic.isAllowedMultipleInstances(),
                documentTypeAnemic.getDisplayOrder(),
                DocumentTypeRulesetConverter.convertMany(documentTypeAnemic.getRulesets()));

        return documentType;
    }

    public static DocumentType[] convertMany(Collection<DocumentTypeAnemic> typeAnemics) {
        if (typeAnemics == null || typeAnemics.isEmpty()) {
            return null;
        }
        var documentTypesList= new ArrayList<DocumentType>();

        for (var typeAnemic : typeAnemics) {
            documentTypesList.add(convertSingle(typeAnemic));
        }

        return documentTypesList.toArray(new DocumentType[documentTypesList.size()]);
    }
}

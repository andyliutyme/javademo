package com.example.demo.data.anemics.document.helpers;

import com.example.demo.api.document.viewmodels.DocumentTypeRuleset;
import com.example.demo.data.anemics.document.DocumentTypeRulesetAnemic;

import java.util.ArrayList;
import java.util.Collection;

public class DocumentTypeRulesetConverter {
    public static DocumentTypeRuleset convertSingle(DocumentTypeRulesetAnemic rulesetAnemic) {
        var documentTypeRuleset = new DocumentTypeRuleset(
                rulesetAnemic.getId(),
                rulesetAnemic.getName(),
                rulesetAnemic.getMinPages(),
                rulesetAnemic.getMaxPages(),
                rulesetAnemic.getSupportedMimeTypes()
        );

        return documentTypeRuleset;
    }

    public static DocumentTypeRuleset[] convertMany(Collection<DocumentTypeRulesetAnemic> rulesetAnemics) {
        if (rulesetAnemics == null || rulesetAnemics.isEmpty()) {
            return null;
        }
        var documentTypeRulesetList= new ArrayList<DocumentTypeRuleset>();

        for (var rulesetAnemic : rulesetAnemics) {
            documentTypeRulesetList.add(convertSingle(rulesetAnemic));
        }

        return documentTypeRulesetList.toArray(new DocumentTypeRuleset[documentTypeRulesetList.size()]);
    }
}

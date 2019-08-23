package com.example.demo.data.repositories.services;

import com.example.demo.data.anemics.document.DocumentTypeRulesetAnemic;
import com.example.demo.data.repositories.interfaces.IDocumentTypeRulesetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentTypeRulesetRepositoryService {
    @Autowired
    private IDocumentTypeRulesetRepository repository;

    public List<DocumentTypeRulesetAnemic> getDocumentTypeRulesets() {
        return this.repository.findAll();
    }

    public void saveChanges(List<DocumentTypeRulesetAnemic> documentTypeRulesets) {
        this.repository.saveAll(documentTypeRulesets);
    }
}

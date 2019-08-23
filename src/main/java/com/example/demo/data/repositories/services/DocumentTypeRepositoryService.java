package com.example.demo.data.repositories.services;

import com.example.demo.data.anemics.document.DocumentTypeAnemic;
import com.example.demo.data.repositories.interfaces.IDocumentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentTypeRepositoryService {
    @Autowired
    private IDocumentTypeRepository repository;

    public List<DocumentTypeAnemic> getDocumentTypes() {
        return this.repository.findAll();
    }

    public void saveChanges(DocumentTypeAnemic documentType) {
        this.repository.save(documentType);
    }

    public void saveChanges(List<DocumentTypeAnemic> documentTypes) {
        this.repository.saveAll(documentTypes);
    }

    public DocumentTypeAnemic getDocumentTypeById(String id) {
        return this.repository.getOne(id);
    }
}

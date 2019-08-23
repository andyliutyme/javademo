package com.example.demo.data.repositories.services;

import com.example.demo.data.anemics.document.DocumentAnemic;
import com.example.demo.data.repositories.interfaces.IDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentRepositoryService {
    @Autowired
    private IDocumentRepository repository;

    public DocumentRepositoryService(IDocumentRepository repository) {
        this.repository = repository;
    }

    public void saveChanges(DocumentAnemic document) {
        this.repository.save(document);
    }
}

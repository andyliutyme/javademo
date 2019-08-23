package com.example.demo.data.repositories.services;

import com.example.demo.data.anemics.document.DocumentPageAnemic;
import com.example.demo.data.repositories.interfaces.IDocumentPageRepository;
import org.springframework.stereotype.Service;

@Service
public class DocumentPageRepositoryService {
    private IDocumentPageRepository repository;

    public DocumentPageRepositoryService(IDocumentPageRepository repository) {
        this.repository = repository;
    }

    public void saveChanges(DocumentPageAnemic documentPage) {
        this.repository.save(documentPage);
    }
}

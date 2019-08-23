package com.example.demo.data.repositories.services;

import com.example.demo.data.anemics.document.DocumentCategoryAnemic;
import com.example.demo.data.repositories.interfaces.IDocumentCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentCategoryRepositoryService {
    @Autowired
    private IDocumentCategoryRepository repository;

    public List<DocumentCategoryAnemic> getDocumentCategories() {
        return this.repository.findAll();
    }

    public void saveChanges(DocumentCategoryAnemic documentCategory) {
        this.repository.save(documentCategory);
    }

    public void saveChanges(List<DocumentCategoryAnemic> documentCategories) {
        this.repository.saveAll(documentCategories);
    }
}

package com.example.demo.data.repositories.interfaces;

import com.example.demo.data.anemics.document.DocumentTypeAnemic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDocumentTypeRepository extends JpaRepository<DocumentTypeAnemic, String> {
}

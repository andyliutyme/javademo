package com.example.demo.data.repositories.interfaces;

import com.example.demo.data.anemics.document.DocumentAnemic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDocumentRepository extends JpaRepository<DocumentAnemic, String> {
}

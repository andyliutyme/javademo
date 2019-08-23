package com.example.demo.data.repositories.interfaces;

import com.example.demo.data.anemics.document.DocumentPageAnemic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDocumentPageRepository extends JpaRepository<DocumentPageAnemic, String> {
}

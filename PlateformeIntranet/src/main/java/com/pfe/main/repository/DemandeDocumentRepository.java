package com.pfe.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pfe.main.entity.DemandeDocument;


public interface DemandeDocumentRepository extends JpaRepository<DemandeDocument, Long> {

}

package com.example.MuhanParking.api.user.repository;

import com.example.MuhanParking.api.user.model.SubmittedDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubmittedDocumentRepository extends JpaRepository<SubmittedDocument, Long> {
    List<SubmittedDocument> findByApplicationId(Long applicationId);
    boolean existsByApplicationIdAndRequiredDocumentId(Long applicationId, Long documentId);
}
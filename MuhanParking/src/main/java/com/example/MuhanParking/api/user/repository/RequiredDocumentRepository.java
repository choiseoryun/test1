package com.example.MuhanParking.api.user.repository;

import com.example.MuhanParking.api.user.model.RequiredDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequiredDocumentRepository extends JpaRepository<RequiredDocument, Long> {
    List<RequiredDocument> findByIsRequiredTrue();
}
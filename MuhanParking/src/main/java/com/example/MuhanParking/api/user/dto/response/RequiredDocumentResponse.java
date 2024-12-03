package com.example.MuhanParking.api.user.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RequiredDocumentResponse {
    private Long documentId;
    private String documentName;
    private String description;
    private Boolean isRequired;
}


package com.example.MuhanParking.api.user.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class DocumentSubmissionStatusResponse {
    private Long submissionId;
    private String documentName;
    private String status;
    private LocalDateTime submittedAt;
    private LocalDateTime submissionDeadline;
}
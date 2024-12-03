package com.example.MuhanParking.api.user.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class RegularParkingApplicationResponse {
    private Long applicationId;
    private String applicationStatus;
    private Integer evaluationScore;
    private LocalDateTime createdAt;
}
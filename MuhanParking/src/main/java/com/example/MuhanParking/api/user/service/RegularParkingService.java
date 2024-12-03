package com.example.MuhanParking.api.user.service;

import com.example.MuhanParking.api.user.dto.request.RegularParkingApplicationRequest;
import com.example.MuhanParking.api.user.dto.response.DocumentSubmissionStatusResponse;
import com.example.MuhanParking.api.user.dto.response.RegularParkingApplicationResponse;
import com.example.MuhanParking.api.user.dto.response.RequiredDocumentResponse;
import com.example.MuhanParking.api.user.model.RegularParkingApplication;
import com.example.MuhanParking.api.user.model.SubmittedDocument;
import com.example.MuhanParking.api.user.repository.RegularParkingApplicationRepository;
import com.example.MuhanParking.api.user.repository.RequiredDocumentRepository;
import com.example.MuhanParking.api.user.repository.SubmittedDocumentRepository;
import com.example.MuhanParking.model.User;
import com.example.MuhanParking.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RegularParkingService {

    private final RegularParkingApplicationRepository applicationRepository;
    private final RequiredDocumentRepository documentRepository;
    private final SubmittedDocumentRepository submittedDocumentRepository;
    private final UserRepository userRepository;  // 사용자 정보 조회용

    // 정기권 신청
    public RegularParkingApplicationResponse applyForParking(Long userId, RegularParkingApplicationRequest request) {
        // 기존 신청 있는지 확인
        if(applicationRepository.findByUserIdAndApplicationStatus(userId, RegularParkingApplication.ApplicationStatus.PENDING).isPresent()) {
            throw new RuntimeException("이미 신청한 정기권이 있습니다!");
        }

        User user = userRepository.findById(userId).get();

        RegularParkingApplication application = new RegularParkingApplication();
        application.setUser(user);
        application.setStudentYear(request.getStudentYear());
        application.setTransportationType(RegularParkingApplication.TransportationType.valueOf(request.getTransportationType()));
        application.setDepartureStation(request.getDepartureStation());
        application.setStationTimeMinutes(request.getStationTimeMinutes());
        application.setPublicTransportTime(request.getPublicTransportTime());
        application.setCarTime(request.getCarTime());

        // 점수 계산 - 일단 대충..
        int score = calculateScore(request);
        application.setEvaluationScore(score);

        RegularParkingApplication saved = applicationRepository.save(application);

        return RegularParkingApplicationResponse.builder()
                .applicationId(saved.getApplicationId())
                .applicationStatus(saved.getApplicationStatus().toString())
                .evaluationScore(saved.getEvaluationScore())
                .createdAt(saved.getCreatedAt())
                .build();
    }

    // 제출해야 하는 서류 목록 조회
    public List<RequiredDocumentResponse> getRequiredDocuments() {
        return documentRepository.findByIsRequiredTrue().stream()
                .map(doc -> RequiredDocumentResponse.builder()
                        .documentId(doc.getDocumentId())
                        .documentName(doc.getDocumentName())
                        .description(doc.getDescription())
                        .isRequired(doc.getIsRequired())
                        .build())
                .collect(Collectors.toList());
    }

    // 서류 제출 상태 조회
    public List<DocumentSubmissionStatusResponse> getDocumentStatus(Long applicationId) {
        List<SubmittedDocument> submittedDocs = submittedDocumentRepository.findByApplicationId(applicationId);

        return submittedDocs.stream()
                .map(doc -> DocumentSubmissionStatusResponse.builder()
                        .submissionId(doc.getSubmissionId())
                        .documentName(doc.getRequiredDocument().getDocumentName())
                        .status(doc.getStatus().toString())
                        .submittedAt(doc.getSubmittedAt())
                        .submissionDeadline(doc.getSubmissionDeadline())
                        .build())
                .collect(Collectors.toList());
    }

    // 점수 계산 - 나중에 더 자세히 구현하기!
    private int calculateScore(RegularParkingApplicationRequest request) {
        int score = 0;

        // 학년 점수
        score += request.getStudentYear() * 10;

        // 대중교통 시간이 자가용보다 오래 걸리면 점수 추가
        if(request.getPublicTransportTime() > request.getCarTime()) {
            score += (request.getPublicTransportTime() - request.getCarTime()) / 10;
        }

        return score;
    }
}
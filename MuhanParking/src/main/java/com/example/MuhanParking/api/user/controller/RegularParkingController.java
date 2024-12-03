package com.example.MuhanParking.api.user.controller;

import com.example.MuhanParking.api.user.dto.request.RegularParkingApplicationRequest;
import com.example.MuhanParking.api.user.dto.response.DocumentSubmissionStatusResponse;
import com.example.MuhanParking.api.user.dto.response.RegularParkingApplicationResponse;
import com.example.MuhanParking.api.user.dto.response.RequiredDocumentResponse;
import com.example.MuhanParking.api.user.service.RegularParkingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/parking/regular")
@RequiredArgsConstructor
public class RegularParkingController {

    private final RegularParkingService parkingService;

    @PostMapping("/applications")
    public ResponseEntity<?> applyForParking(
            @AuthenticationPrincipal UserDetails userDetails,
            @RequestBody RegularParkingApplicationRequest request) {
        try {
            // 일단 user id는 1L로 하드코딩.. 나중에 수정하기
            RegularParkingApplicationResponse response =
                    parkingService.applyForParking(1L, request);
            return ResponseEntity.ok(response);
        } catch(Exception e) {
            // 나중에 예외처리 제대로 하기!!
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/required-documents")
    public ResponseEntity<List<RequiredDocumentResponse>> getRequiredDocuments() {
        List<RequiredDocumentResponse> documents = parkingService.getRequiredDocuments();
        return ResponseEntity.ok(documents);
    }

    @GetMapping("/documents/{applicationId}")
    public ResponseEntity<?> getDocumentStatus(@PathVariable Long applicationId) {
        try {
            List<DocumentSubmissionStatusResponse> status =
                    parkingService.getDocumentStatus(applicationId);
            return ResponseEntity.ok(status);
        } catch(Exception e) {
            // 여기도 나중에 예외처리하기
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // 파일 업로드는 나중에 구현하기!
    @PostMapping("/documents")
    public ResponseEntity<?> uploadDocument(
            @RequestParam("applicationId") Long applicationId,
            @RequestParam("documentId") Long documentId,
            @RequestParam("file") MultipartFile file) {
        return ResponseEntity.ok("파일 업로드 성공!");
    }
}
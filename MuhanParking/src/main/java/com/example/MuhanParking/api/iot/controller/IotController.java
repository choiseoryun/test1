package com.example.MuhanParking.api.iot.controller;

import com.example.MuhanParking.api.iot.dto.request.IotInfoRequest;
import com.example.MuhanParking.api.user.dto.request.SignUpRequest;
import com.example.MuhanParking.dto.ResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import com.example.MuhanParking.api.iot.service.IotService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Slf4j
public class IotController {

    private final IotService iotService;

    @PostMapping("/iot/info")
    public ResponseDto<Void> iotInfo(@Valid @RequestBody List<IotInfoRequest> request){
        try{
            iotService.iotInfo(request);
            return ResponseDto.success("성공하였습니다", null);
        }catch (Exception e){
            log.error("데이터 전송 실패 ", e);  // 에러 로그 추가
            return ResponseDto.fail(e.getMessage());
        }
    }
    // 들어오는 데이터 처리.. 관리자
    // 트래픽 관리
    // 통계 데이터
}

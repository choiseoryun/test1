package com.example.MuhanParking.api.iot.service;

import com.example.MuhanParking.api.iot.dto.request.IotInfoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class IotService {
    @Transactional
    public void iotInfo(List<IotInfoRequest> request){
        int occupiedTrueCount = 0;
        int occupiedFalseCount = 0;
        for (IotInfoRequest info : request) {
            if (info.isOccupied()) {
                occupiedTrueCount++;
            } else {
                occupiedFalseCount++;
            }
        }
        System.out.println("Occupied True Count: " + occupiedTrueCount);
        System.out.println("Occupied False Count: " + occupiedFalseCount);
    }
}

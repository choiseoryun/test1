package com.example.MuhanParking.api.user.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RegularParkingApplicationRequest {
    private Integer studentYear;
    private String transportationType;
    private String departureStation;
    private Integer stationTimeMinutes;
    private Integer publicTransportTime;
    private Integer carTime;
}
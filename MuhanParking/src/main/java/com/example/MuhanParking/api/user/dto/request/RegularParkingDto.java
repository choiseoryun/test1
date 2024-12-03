package com.example.MuhanParking.api.user.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegularParkingDto {
    private Integer studentYear;
    private String transportationType;
    private String departureStation;
    private Integer stationTimeMinutes;
    private Integer publicTransportTime;
    private Integer carTime;
}
package com.example.MuhanParking.api.iot.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class IotInfoRequest {
    private int number;
    private boolean occupied;
}

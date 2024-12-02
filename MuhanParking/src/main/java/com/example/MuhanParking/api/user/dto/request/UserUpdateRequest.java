package com.example.MuhanParking.api.user.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserUpdateRequest {
    private String phone;
    private String address;
    private String password;  // 선택적으로 비밀번호 변경
}
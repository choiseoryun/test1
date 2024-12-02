package com.example.MuhanParking.api.user.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FindUsernameRequest {
    @NotBlank(message = "이름을 입력해주세요")
    private String name;

    @NotNull(message = "학번을 입력해주세요")
    private Integer studentId;

    @NotBlank(message = "생년월일을 입력해주세요")
    private String birthDate;
}
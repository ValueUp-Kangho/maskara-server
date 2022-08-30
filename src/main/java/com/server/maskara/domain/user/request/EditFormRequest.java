package com.server.maskara.domain.user.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
public class EditFormRequest {
    @NotEmpty(message = "닉네임는 필수 정보입니다.")
    private String nickname;
    @NotEmpty(message = "사는 지역은 필수 정보입니다.")
    private String residence;
}
package com.server.maskara.domain.user.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
public class EditFormRequest {
    @ApiModelProperty(value="회원 닉네임", dataType = "string", required = true)
    @NotEmpty(message = "닉네임는 필수 정보입니다.")
    private String nickname;
    @ApiModelProperty(value="거주지", dataType = "string", required = true)
    @NotEmpty(message = "사는 지역은 필수 정보입니다.")
    private String residence;
}
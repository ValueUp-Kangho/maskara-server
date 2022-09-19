package com.server.maskara.domain.user.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RegisterFormRequest {
    @ApiModelProperty(value="회원 ID", dataType = "string", required = true)
    private String id;
    @ApiModelProperty(value="회원 닉네임", dataType = "string", required = true)
    private String nickname;
    @ApiModelProperty(value="회원 비밀번호", dataType = "string", required = true)
    private String password;
    @ApiModelProperty(value="거주지", dataType = "string", required = true)
    private String residence;
}

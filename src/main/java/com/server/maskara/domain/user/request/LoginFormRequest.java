package com.server.maskara.domain.user.request;


import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
public class LoginFormRequest {
    @ApiModelProperty(value="회원 ID", dataType = "string", required = true)
    @NotEmpty(message = "아이디를 입력해주세요.")
    private String id;
    @ApiModelProperty(value="회원 비밀번호", dataType = "string", required = true)
    @NotEmpty(message = "비밀번호를 입력해주세요.")
    private String password;
}

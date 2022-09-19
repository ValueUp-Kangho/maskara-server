package com.server.maskara.domain.user.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserBasicInfoResponse {
    @ApiModelProperty(value="회원 ID", dataType = "string", required = true)
    private String id;
    @ApiModelProperty(value="회원 닉네임", dataType = "string", required = true)
    private String nickname;
    @ApiModelProperty(value="거주지", dataType = "string", required = true)
    private String residence;
}
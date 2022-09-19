package com.server.maskara.domain.user.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserDetailResponse {
    @ApiModelProperty(value="회원 닉네임", dataType = "string", required = true)
    private String nickname;
    @ApiModelProperty(value="포인트", dataType = "int", required = true)
    private int point;
    @ApiModelProperty(value="거주지", dataType = "string", required = true)
    private String residence;
    @ApiModelProperty(value="마스크 버린 횟수", dataType = "string", required = true)
    private int count;
}

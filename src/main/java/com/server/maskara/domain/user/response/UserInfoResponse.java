package com.server.maskara.domain.user.response;

import com.server.maskara.domain.user.dto.UserActivityDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class UserInfoResponse {
    @ApiModelProperty(value="회원 닉네임", dataType = "string", required = true)
    private String nickname;
    @ApiModelProperty(value="포인트", dataType = "int", required = true)
    private int point;
    @ApiModelProperty(value="버린 마스크 개수", dataType = "int", required = true)
    private int maskCount;
    @ApiModelProperty(value="거주지", dataType = "string", required = true)
    private String residence;
    @ApiModelProperty(value="활동 내역", dataType = "list<UserActivityDto>", required = true)
    List<UserActivityDto> activityRecord = new ArrayList<>();
}
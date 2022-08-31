package com.server.maskara.domain.user.response;

import com.server.maskara.domain.user.dto.UserActivityDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class UserInfoResponse {
    private String nickname;
    private int point;
    private int maskCount;
    private String residence;
    List<UserActivityDto> activityRecord = new ArrayList<>();
}
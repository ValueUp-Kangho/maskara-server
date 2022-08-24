package com.server.mascara.domain.user.response;

import com.server.mascara.domain.user.dto.UserActivityDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class UserInfoResponse {
    private String nickname;
    private int point;
    private String residence;
    List<UserActivityDto> activityRecord = new ArrayList<>();
}
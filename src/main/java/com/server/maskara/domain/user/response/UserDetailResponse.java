package com.server.maskara.domain.user.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserDetailResponse {
    private String nickname;
    private int point;
    private String residence;
    private int count;
}

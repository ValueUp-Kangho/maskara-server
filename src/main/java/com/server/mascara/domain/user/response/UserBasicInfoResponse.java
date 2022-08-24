package com.server.mascara.domain.user.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserBasicInfoResponse {
    private String id;
    private String nickname;
    private String residence;
}
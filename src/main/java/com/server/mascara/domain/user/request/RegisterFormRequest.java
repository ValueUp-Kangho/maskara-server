package com.server.mascara.domain.user.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RegisterFormRequest {
    private String id;
    private String nickname;
    private String password;
    private String residence;
}

package com.server.maskara.controller.user;

import com.server.maskara.advice.exception.FieldErrorException;
import com.server.maskara.advice.exception.LoginFailedException;
import com.server.maskara.config.security.JwtTokenProvider;
import com.server.maskara.domain.response.CommonResult;
import com.server.maskara.domain.response.SingleResult;
import com.server.maskara.domain.user.request.LoginFormRequest;
import com.server.maskara.domain.user.request.RegisterFormRequest;
import com.server.maskara.entity.User;
import com.server.maskara.service.ResponseService;
import com.server.maskara.service.user.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class SignController {

    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;
    private final ResponseService responseService;

    @ApiOperation(value = "로그인", notes = "로그인 시, 해당 로그인를 검증한다.")
    @PostMapping("/login")
    public SingleResult<String> login(@Validated @RequestBody LoginFormRequest form, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new FieldErrorException();
        }

        User user = userService.findByUsername(form.getId());

        if (!passwordEncoder.matches(form.getPassword(), user.getPassword())) {
            throw new LoginFailedException();
        }

        return responseService.getSingleResult(jwtTokenProvider.createToken(String.valueOf(user.getId()), user.getRoles()),
                200, "로그인 성공");
    }

    @ApiOperation(value = "회원가입", notes = "회원가입 필드값을 검증하고, 회원가입을 하도록 한다.")
    @PostMapping( "/signup")
    public CommonResult signUp(@Valid @RequestBody RegisterFormRequest form, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new FieldErrorException();
        }

        userService.save(form);
        return responseService.getCommonResult(200, form.getNickname() + "님의 회원가입 성공");
    }

    @ApiOperation(value = "로그아웃", notes = "로그인한 회원을 로그아웃한다.")
    @PostMapping("/logout")
    public CommonResult logout() {
        return responseService.getCommonResult(200, "로그아웃 성공");
    }
}

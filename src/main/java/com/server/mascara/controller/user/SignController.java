package com.server.mascara.controller.user;

import com.server.mascara.advice.exception.FieldErrorException;
import com.server.mascara.advice.exception.LoginFailedException;
import com.server.mascara.config.security.JwtTokenProvider;
import com.server.mascara.domain.response.CommonResult;
import com.server.mascara.domain.response.SingleResult;
import com.server.mascara.domain.user.LoginFormRequest;
import com.server.mascara.domain.user.RegisterFormRequest;
import com.server.mascara.entity.User;
import com.server.mascara.service.ResponseService;
import com.server.mascara.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class SignController {

    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;
    private final ResponseService responseService;

    @PostMapping("/login")
    public SingleResult<String> signIn(@Validated @ModelAttribute LoginFormRequest form, BindingResult bindingResult) {

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

    @PostMapping(value = "/signup")
    public CommonResult signUp(@Valid @ModelAttribute RegisterFormRequest form, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new FieldErrorException();
        }

        userService.save(form);
        return responseService.getCommonResult(200, form.getNickname() + "님의 회원가입 성공");
    }
}

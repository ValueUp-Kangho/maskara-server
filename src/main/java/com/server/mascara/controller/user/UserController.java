package com.server.mascara.controller.user;

import com.server.mascara.config.security.JwtTokenProvider;
import com.server.mascara.domain.response.CommonResult;
import com.server.mascara.domain.response.ListResult;
import com.server.mascara.domain.response.SingleResult;
import com.server.mascara.entity.User;
import com.server.mascara.service.ResponseService;
import com.server.mascara.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;
    private final ResponseService responseService;

    @GetMapping("/users")
    public ListResult<User> findAllUser() {
        return responseService.getListResult(userService.findAll(), 200, "모든 회원 조회");
    }

    @GetMapping("/user")
    public SingleResult<User> findUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String id = authentication.getName();

        return responseService.getSingleResult(userService.findByUsername(id), 200, "회원 조회");
    }

    @PutMapping(value = "/user")
    public CommonResult modify(@RequestParam String name) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String id = authentication.getName();
        User user = userService.findByUsername(id);
        user.setNickName(name);
        return responseService.getCommonResult(200, name + "님의 닉네임 변경");
    }

    @DeleteMapping(value = "/user/{userId}")
    public CommonResult delete(@PathVariable long userId) {
        userService.deleteById(userId);
        return responseService.getCommonResult(200, userId + " 회원 삭제");
    }
}
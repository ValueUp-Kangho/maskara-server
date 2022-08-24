package com.server.mascara.controller.user;

import com.server.mascara.domain.response.CommonResult;
import com.server.mascara.domain.response.ListResult;
import com.server.mascara.domain.user.dto.UserActivityDto;
import com.server.mascara.domain.user.response.UserBasicInfoResponse;
import com.server.mascara.domain.user.response.UserInfoResponse;
import com.server.mascara.entity.User;
import com.server.mascara.service.ResponseService;
import com.server.mascara.service.activityRecord.ActivityRecordService;
import com.server.mascara.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;
    private final ActivityRecordService activityRecordService;
    private final ResponseService responseService;

    @GetMapping("/users")
    public ListResult<User> findAllUser() {
        return responseService.getListResult(userService.findAll(), 200, "모든 회원 조회");
    }

    @GetMapping("/mypage")
    public UserInfoResponse getUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String id = authentication.getName();

        User user = userService.findByUsername(id);
        List<UserActivityDto> userActivityDto = activityRecordService.getUserActivityDtoByUser(user);

        return new UserInfoResponse(user.getNickName(), user.getPoint(), user.getResidence(), userActivityDto);
    }

    @GetMapping("/mypage/edit")
    public UserBasicInfoResponse getUserBasicInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String id = authentication.getName();

        User user = userService.findByUsername(id);
        return new UserBasicInfoResponse(user.getUsername(), user.getNickName(), user.getResidence());
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
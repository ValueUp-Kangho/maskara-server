package com.server.maskara.controller.user;

import com.server.maskara.advice.exception.FieldErrorException;
import com.server.maskara.domain.response.CommonResult;
import com.server.maskara.domain.response.ListResult;
import com.server.maskara.domain.user.dto.UserActivityDto;
import com.server.maskara.domain.user.request.EditFormRequest;
import com.server.maskara.domain.user.response.UserBasicInfoResponse;
import com.server.maskara.domain.user.response.UserInfoResponse;
import com.server.maskara.entity.User;
import com.server.maskara.service.ResponseService;
import com.server.maskara.service.activityRecord.ActivityRecordService;
import com.server.maskara.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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

    @Transactional
    @PutMapping("/mypage/edit")
    public CommonResult modify(@Validated @ModelAttribute EditFormRequest form, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new FieldErrorException();
        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String id = authentication.getName();
        User user = userService.findByUsername(id);

        user.setUsername(form.getId());
        user.setNickName(form.getNickname());
        user.setResidence(form.getResidence());

        return responseService.getCommonResult(200, "마이페이지 수정 성공");
    }

    @DeleteMapping(value = "/user/{userId}")
    public CommonResult delete(@PathVariable long userId) {
        userService.deleteById(userId);
        return responseService.getCommonResult(200, userId + " 회원 삭제");
    }
}
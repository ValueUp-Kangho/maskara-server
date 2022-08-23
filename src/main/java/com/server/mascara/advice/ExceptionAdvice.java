package com.server.mascara.advice;

import com.server.mascara.advice.exception.FieldErrorException;
import com.server.mascara.advice.exception.LoginFailedException;
import com.server.mascara.advice.exception.UserNotFoundException;
import com.server.mascara.domain.response.CommonResult;
import com.server.mascara.service.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@RestController
@ControllerAdvice
public class ExceptionAdvice {

    private final ResponseService responseService;

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected CommonResult commonException(HttpServletRequest request, Exception e) {
        return responseService.getCommonResult(500, "Common Exception");
    }

    @ExceptionHandler(LoginFailedException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    protected CommonResult loginFailedException(HttpServletRequest request, Exception e) {
        return responseService.getCommonResult(404, "Login Failed");
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected CommonResult userNotFoundException(HttpServletRequest request, Exception e) {
        return responseService.getCommonResult(500, "Not Found User");
    }

    @ExceptionHandler(FieldErrorException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected CommonResult fieldErrorException(HttpServletRequest request, Exception e) {
        return responseService.getCommonResult(400, "Field Error");
    }
}

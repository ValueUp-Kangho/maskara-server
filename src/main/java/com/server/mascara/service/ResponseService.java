package com.server.mascara.service;

import com.server.mascara.domain.response.CommonResult;
import com.server.mascara.domain.response.ListResult;
import com.server.mascara.domain.response.SingleResult;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponseService {

    // 단일건 결과를 처리하는 메소드
    public <T> SingleResult<T> getSingleResult(T data, int code, String msg) {
        SingleResult<T> result = new SingleResult<>();
        result.setData(data);
        result.setCode(code);
        result.setMessage(msg);
        return result;
    }

    // 다중건 결과를 처리하는 메소드
    public <T> ListResult<T> getListResult(List<T> list, int code, String msg) {
        ListResult<T> result = new ListResult<>();
        result.setList(list);
        result.setCode(code);
        result.setMessage(msg);
        return result;
    }

    // 성공 결과만 처리하는 메소드
    public CommonResult getCommonResult(int code, String msg) {
        CommonResult result = new CommonResult();
        result.setCode(code);
        result.setMessage(msg);
        return result;
    }
}

package com.server.maskara.domain.qr.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;


@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
public class ResponseQr {
    @ApiModelProperty(value="버린 마스크의 개수", dataType = "int", required = true)
    private int maskCount;
    @ApiModelProperty(value="마스크 수거함의 주소", dataType = "string", required = true)
    private String location;
    @ApiModelProperty(value = "마스크를 버린 날짜", dataType = "localDateTime", required = true)
    private LocalDateTime date;
    @ApiModelProperty(value="획득 포인트", dataType = "int", required = true)
    private int point;
    @ApiModelProperty(value="회원의 누적 포인트", dataType = "int", required = true)
    private int sumPoint;
}

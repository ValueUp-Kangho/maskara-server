package com.server.maskara.domain.qr.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@Getter
public class RequestQr {
    @ApiModelProperty(value="마스크 수거함 시리얼 넘버", dataType = "string", required = true)
    private String collectionBoxSerialNumber;
    @ApiModelProperty(value="회원이 버린 마스크의 개수", dataType = "int", required = true)
    private int maskCount;
}

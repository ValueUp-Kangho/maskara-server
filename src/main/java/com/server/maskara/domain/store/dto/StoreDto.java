package com.server.maskara.domain.store.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class StoreDto {
    @ApiModelProperty(value="친환경 스토어 PK", dataType = "long", required = true)
    private Long id;
    @ApiModelProperty(value="친환경 스토어 명", dataType = "string", required = true)
    private String name;
    @ApiModelProperty(value="친환경 스토어 주소", dataType = "string", required = true)
    private String address;
    @ApiModelProperty(value="친환경 스토어 연락처", dataType = "string", required = true)
    private String phoneNumber;
    @ApiModelProperty(value="친환경 스토어 이미지 경로", dataType = "string", required = true)
    private String imgUrl;
    @ApiModelProperty(value="친환경 스토어 사이트 주소", dataType = "string", required = true)
    private String siteUrl;
}

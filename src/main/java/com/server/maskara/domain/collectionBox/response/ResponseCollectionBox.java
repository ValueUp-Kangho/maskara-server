package com.server.maskara.domain.collectionBox.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
public class ResponseCollectionBox {
    @ApiModelProperty(value="마스크 수거함 명", dataType = "string", required = true)
    private String name;
    @ApiModelProperty(value="마스크 수거함 설치 주소", dataType = "string", required = true)
    private String address;
    @ApiModelProperty(value="마스크 수거함 이미지 경로", dataType = "string", required = true)
    private String imgUrl;
}

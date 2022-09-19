package com.server.maskara.domain.collectionBox.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
public class ResponseCollectionBoxPos {
    @ApiModelProperty(value="마스크 수거함 PK", dataType = "long", required = true)
    private Long id;
    @ApiModelProperty(value="마스크 수거함 명", dataType = "string", required = true)
    private String name;
    @ApiModelProperty(value="마스크 수거함 위치 - 위도", dataType = "double", required = true)
    private Double latitude;
    @ApiModelProperty(value="마스크 수거함 위치 - 경도", dataType = "double", required = true)
    private Double longitude;
}

package com.server.maskara.domain.activityRecord.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ResidenceRankDto {
    @ApiModelProperty(value="지역명", dataType = "string", required = true)
    private String residence;
    @ApiModelProperty(value="지역별 마스크 수거 횟수", dataType = "long", required = true)
    private Long count;
}

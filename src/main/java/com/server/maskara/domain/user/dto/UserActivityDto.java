package com.server.maskara.domain.user.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class UserActivityDto {
    @ApiModelProperty(value="마스크 수거함 명", dataType = "string", required = true)
    private String collectionBoxName;
    @ApiModelProperty(value="버린 마스크 개수", dataType = "int", required = true)
    private int maskCount;
    @ApiModelProperty(value="마스크 수거함 주소", dataType = "string", required = true)
    private String location;
    @ApiModelProperty(value="마스크 버린 날짜", dataType = "localDateTime", required = true)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime date;
}
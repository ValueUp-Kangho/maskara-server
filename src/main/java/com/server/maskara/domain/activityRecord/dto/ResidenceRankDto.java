package com.server.maskara.domain.activityRecord.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ResidenceRankDto {
    private String residence;
    private Long count;
}

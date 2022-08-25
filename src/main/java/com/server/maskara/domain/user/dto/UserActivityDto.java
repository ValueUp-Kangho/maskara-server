package com.server.maskara.domain.user.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class UserActivityDto {
    private String collectionBoxName;
    private int maskCount;
    private String location;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime date;
}
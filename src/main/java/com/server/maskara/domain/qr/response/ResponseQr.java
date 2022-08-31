package com.server.maskara.domain.qr.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;


@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
public class ResponseQr {
    private int maskCount;
    private String location;
    private LocalDate date;
    private int point;
    private int sumPoint;
}

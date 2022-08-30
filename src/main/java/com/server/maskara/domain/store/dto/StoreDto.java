package com.server.maskara.domain.store.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class StoreDto {
    private Long id;
    private String name;
    private String address;
    private String phoneNumber;
    private String imgUrl;
    private String siteUrl;
}

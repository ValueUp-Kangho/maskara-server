package com.server.maskara.domain.store.response;

import com.server.maskara.domain.store.dto.StoreDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class StoreResponse {
    List<StoreDto> store;
}

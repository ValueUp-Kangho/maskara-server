package com.server.maskara.domain.store.response;

import com.server.maskara.domain.store.dto.StoreDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class StoreResponse {
    @ApiModelProperty(value="친환경 스토어 배열", dataType = "list", required = true)
    List<StoreDto> store;
}

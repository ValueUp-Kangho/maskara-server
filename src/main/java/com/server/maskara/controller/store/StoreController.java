package com.server.maskara.controller.store;

import com.server.maskara.domain.store.dto.StoreDto;
import com.server.maskara.domain.store.response.StoreResponse;
import com.server.maskara.service.store.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;

    @GetMapping("/store")
    public ResponseEntity<StoreResponse> getStores() {
        List<StoreDto> storeDtoList = storeService.getStoreDto();

        return ResponseEntity.status(HttpStatus.OK)
                .body(new StoreResponse(storeDtoList));
    }
}

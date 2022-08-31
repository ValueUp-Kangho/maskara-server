package com.server.maskara.service.store;

import com.server.maskara.domain.store.dto.StoreDto;
import com.server.maskara.entity.Store;
import com.server.maskara.respository.store.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;

    public List<StoreDto> getStoreDto() {
        List<StoreDto> storeDtoList = new ArrayList<>();
        List<Store> stores = storeRepository.findAll();

        for (Store store : stores) {
            StoreDto storeDto = StoreDto.builder()
                    .id(store.getId())
                    .name(store.getName())
                    .address(store.getAddress())
                    .phoneNumber(store.getPhoneNumber())
                    .imgUrl(store.getImgUrl())
                    .siteUrl(store.getSiteUrl())
                    .build();
            storeDtoList.add(storeDto);
        }
        return storeDtoList;
    }
}

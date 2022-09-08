package com.server.maskara.controller.collectionBox;

import com.server.maskara.domain.collectionBox.response.ResponseCollectionBox;
import com.server.maskara.domain.collectionBox.response.ResponseCollectionBoxPos;
import com.server.maskara.entity.CollectionBox;
import com.server.maskara.service.collectionBox.CollectionBoxService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CollectionBoxController {
    private final CollectionBoxService collectionBoxService;

    @ApiOperation(value = "마스크 수거함 기본 정보 조회", notes = "지도에 표시한 마스크 수거함의 기본 정보를 조회한다.")
    @GetMapping("/collectionbox/{id}")
    public ResponseEntity<ResponseCollectionBox> getCollectionBox(@PathVariable Long id) {
        CollectionBox collectionBox = collectionBoxService.getCollectionBoxById(id);

        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseCollectionBox(collectionBox.getName(), collectionBox.getAddress(), collectionBox.getImgUrl()));
    }

    @ApiOperation(value = "지도에 표시할 모든 마스크 수거함의 위치 정보를 조회", notes = "지도에 표시할 모든 마스크 수거함의 경도, 위도 정보를 조회한다.")
    @GetMapping("/collectionbox")
    public ResponseEntity<List<ResponseCollectionBoxPos>> getCollectionBoxes() {
        List<CollectionBox> collectionBoxes = collectionBoxService.getAllCollectionBox();

        List<ResponseCollectionBoxPos> result = new ArrayList<>();
        collectionBoxes.forEach(v -> {
            result.add(new ResponseCollectionBoxPos(
                    v.getId(), v.getName(), v.getLatitude(), v.getLongitude()));
        });

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}

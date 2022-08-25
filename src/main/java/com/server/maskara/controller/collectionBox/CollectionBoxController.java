package com.server.maskara.controller.collectionBox;

import com.server.maskara.domain.collectionBox.response.ResponseCollectionBox;
import com.server.maskara.domain.collectionBox.response.ResponseCollectionBoxPos;
import com.server.maskara.entity.CollectionBox;
import com.server.maskara.service.collectionBox.CollectionBoxService;
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

    @GetMapping("/collectionbox/{id}")
    public ResponseEntity<ResponseCollectionBox> getCollectionBox(@PathVariable Long id) {
        CollectionBox collectionBox = collectionBoxService.getCollectionBoxById(id);

        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseCollectionBox(collectionBox.getName(), collectionBox.getAddress()));
    }

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

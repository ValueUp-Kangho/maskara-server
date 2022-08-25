package com.server.maskara.service.collectionBox;

import com.server.maskara.entity.CollectionBox;
import com.server.maskara.respository.collectionBox.CollectionBoxRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CollectionBoxService {
    private final CollectionBoxRepository collectionBoxRepository;

    public List<CollectionBox> getAllCollectionBox() {
        return collectionBoxRepository.findAll();
    }

    public CollectionBox getCollectionBoxById(Long id) {
        Optional<CollectionBox> collectionBox = collectionBoxRepository.findById(id);

        if (collectionBox.isEmpty())
            throw new RuntimeException();

        return collectionBox.get();
    }
}

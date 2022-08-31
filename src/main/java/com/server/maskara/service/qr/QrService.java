package com.server.maskara.service.qr;

import com.server.maskara.domain.qr.request.RequestQr;
import com.server.maskara.domain.qr.response.ResponseQr;
import com.server.maskara.entity.CollectionBox;
import com.server.maskara.entity.User;
import com.server.maskara.respository.user.UserRepository;
import com.server.maskara.service.collectionBox.CollectionBoxService;
import com.server.maskara.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class QrService {

    private final UserService userService;
    private final CollectionBoxService collectionBoxService;

    public ResponseQr scanQr(String username, RequestQr requestQr){
        CollectionBox collectionBox = collectionBoxService
                .getCollectionBoxBySerialNumber(requestQr.getCollectionBoxSerialNumber());

        return ResponseQr.builder()
                .maskCount(requestQr.getMaskCount())
                .location(collectionBox.getAddress())
                .date(LocalDate.now())
                .point(1)
                .point(userService.updateUserPoint(username))
                .build();
    }

}

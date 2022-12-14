package com.server.maskara.service.qr;

import com.server.maskara.domain.qr.request.RequestQr;
import com.server.maskara.domain.qr.response.ResponseQr;
import com.server.maskara.entity.CollectionBox;
import com.server.maskara.entity.User;
import com.server.maskara.service.activityRecord.ActivityRecordService;
import com.server.maskara.service.collectionBox.CollectionBoxService;
import com.server.maskara.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class QrService {
    private final UserService userService;
    private final CollectionBoxService collectionBoxService;
    private final ActivityRecordService activityRecordService;

    public ResponseQr scanQr(String username, RequestQr requestQr) {
        User user = userService.findByUsername(username);
        int earnPoint = 0;

        if (activityRecordService.isFirstActivity(user)) {
            user.addPoint(1);
            earnPoint = 1;
        }

        CollectionBox collectionBox = collectionBoxService
                .getCollectionBoxBySerialNumber(requestQr.getCollectionBoxSerialNumber());
        activityRecordService.createActivityRecord(user, collectionBox, requestQr.getMaskCount());

        return ResponseQr.builder()
                .maskCount(requestQr.getMaskCount())
                .location(collectionBox.getAddress())
                .date(LocalDateTime.now())
                .point(earnPoint)
                .sumPoint(user.getPoint())
                .build();
    }
}

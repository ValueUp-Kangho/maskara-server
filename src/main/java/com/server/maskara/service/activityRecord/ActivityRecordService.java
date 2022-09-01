package com.server.maskara.service.activityRecord;

import com.server.maskara.domain.activityRecord.dto.ResidenceRankDto;
import com.server.maskara.domain.user.dto.UserActivityDto;
import com.server.maskara.entity.ActivityRecord;
import com.server.maskara.entity.CollectionBox;
import com.server.maskara.entity.User;
import com.server.maskara.respository.activityRecord.ActivityRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ActivityRecordService {

    private final ActivityRecordRepository activityRecordRepository;

    public void createActivityRecord(User user, CollectionBox collectionBox, int maskCount) {
        ActivityRecord activityRecord = ActivityRecord.builder()
                .user(user)
                .collectionBox(collectionBox)
                .date(LocalDateTime.now())
                .maskCount(maskCount)
                .residence(user.getResidence())
                .build();

        activityRecordRepository.save(activityRecord);
    }

    public List<UserActivityDto> getUserActivityDtoByUser(User user) {
        List<UserActivityDto> activityDtoList = new ArrayList<>();
        List<ActivityRecord> activityRecords = activityRecordRepository.findByUser(user);

        for (ActivityRecord activityRecord : activityRecords) {
            UserActivityDto userActivityDto = UserActivityDto.builder()
                    .collectionBoxName(activityRecord.getCollectionBox().getName())
                    .location(activityRecord.getCollectionBox().getAddress())
                    .maskCount(activityRecord.getMaskCount())
                    .date(activityRecord.getDate())
                    .build();
            activityDtoList.add(userActivityDto);
        }
        return activityDtoList;
    }

    public int getCountActivityRecord(User user) {
        return activityRecordRepository.findByUser(user).size();
    }

    public List<ResidenceRankDto> getResidenceRank() {
        return activityRecordRepository.getResidenceRank();
    }

    public int getMaskCount(User user) {
        List<ActivityRecord> records = activityRecordRepository.findByUser(user);
        int maskCount = 0;

        for (ActivityRecord record : records) {
            maskCount += record.getMaskCount();
        }

        return maskCount;
    }

    public boolean isFirstActivity(User user) {
        List<ActivityRecord> optActivityRecord = activityRecordRepository.getTodayActivity(user);

        return optActivityRecord.isEmpty();
    }
}
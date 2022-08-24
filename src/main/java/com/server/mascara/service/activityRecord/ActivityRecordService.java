package com.server.mascara.service.activityRecord;

import com.server.mascara.domain.user.dto.UserActivityDto;
import com.server.mascara.entity.ActivityRecord;
import com.server.mascara.entity.User;
import com.server.mascara.respository.activityRecord.ActivityRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ActivityRecordService {

    private final ActivityRecordRepository activityRecordRepository;

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
}
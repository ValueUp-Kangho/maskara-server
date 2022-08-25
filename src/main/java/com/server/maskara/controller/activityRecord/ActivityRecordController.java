package com.server.maskara.controller.activityRecord;

import com.server.maskara.domain.activityRecord.dto.ResidenceRankDto;
import com.server.maskara.service.activityRecord.ActivityRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ActivityRecordController {

    private final ActivityRecordService activityRecordService;

    @GetMapping("/residence/rank")
    public List<ResidenceRankDto> getResidenceRank() {
        return activityRecordService.getResidenceRank();
    }
}

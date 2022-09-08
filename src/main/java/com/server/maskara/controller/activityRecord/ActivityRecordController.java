package com.server.maskara.controller.activityRecord;

import com.server.maskara.domain.activityRecord.dto.ResidenceRankDto;
import com.server.maskara.service.activityRecord.ActivityRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

    @ApiOperation(value = "지역별 순위 조회", notes = "지역별로 사람들이 마스크를 버린 횟수를 내림차순으로 조회한다.")
    @GetMapping("/residence/rank")
    public List<ResidenceRankDto> getResidenceRank() {
        return activityRecordService.getResidenceRank();
    }
}

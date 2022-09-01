package com.server.maskara.respository.activityRecord;

import com.server.maskara.domain.activityRecord.dto.ResidenceRankDto;
import com.server.maskara.entity.ActivityRecord;
import com.server.maskara.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ActivityRecordRepository extends JpaRepository<ActivityRecord, Long> {

    List<ActivityRecord> findByUser(User user);

    @Query("SELECT distinct " +
            "new com.server.maskara.domain.activityRecord.dto.ResidenceRankDto(a.residence, COUNT(a.residence)) " +
            "FROM ActivityRecord a " +
            "GROUP BY a.residence " +
            "ORDER BY COUNT(a.residence) DESC")
    List<ResidenceRankDto> getResidenceRank();

    @Query("SELECT a FROM ActivityRecord a WHERE a.user = :user AND DATE(a.date) = DATE(NOW())")
    List<ActivityRecord> getTodayActivity(@Param("user") User user);
}
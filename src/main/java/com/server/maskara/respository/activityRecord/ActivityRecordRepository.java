package com.server.maskara.respository.activityRecord;

import com.server.maskara.entity.ActivityRecord;
import com.server.maskara.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityRecordRepository extends JpaRepository<ActivityRecord, Long> {

    List<ActivityRecord> findByUser(User user);
}
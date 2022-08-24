package com.server.mascara.respository.activityRecord;

import com.server.mascara.entity.ActivityRecord;
import com.server.mascara.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityRecordRepository extends JpaRepository<ActivityRecord, Long> {

    List<ActivityRecord> findByUser(User user);
}
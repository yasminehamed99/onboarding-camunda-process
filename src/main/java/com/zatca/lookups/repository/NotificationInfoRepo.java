package com.zatca.lookups.repository;

import com.zatca.lookups.entity.configuration.notification.NotificationInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationInfoRepo extends JpaRepository<NotificationInfo, Long> {
}

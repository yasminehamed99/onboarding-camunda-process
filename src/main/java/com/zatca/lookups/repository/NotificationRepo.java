package com.zatca.lookups.repository;

import com.zatca.lookups.entity.configuration.notification.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepo extends JpaRepository<Notification, Long> {
}

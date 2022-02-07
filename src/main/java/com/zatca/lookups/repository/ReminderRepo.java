package com.zatca.lookups.repository;

import com.zatca.lookups.entity.configuration.notification.Reminder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReminderRepo extends JpaRepository<Reminder, Long> {
}

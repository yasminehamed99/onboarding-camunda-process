package com.zatca.lookups.service;

import com.zatca.lookups.api.v1.dto.notification.NotificationDTO;
import com.zatca.lookups.entity.configuration.notification.Notification;
import com.zatca.lookups.entity.configuration.notification.NotificationInfo;
import com.zatca.lookups.entity.configuration.notification.Reminder;
import com.zatca.lookups.repository.NotificationInfoRepo;
import com.zatca.lookups.repository.NotificationRepo;
import com.zatca.lookups.repository.ReminderRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NotificationService {

    @Autowired
    private NotificationRepo notificationRepo;

    @Autowired
    private NotificationInfoRepo notificationInfoRepo;

    @Autowired
    private ReminderRepo reminderRepo;

    public void saveNotificationConfig(NotificationDTO request) {


//        NotificationInfo smeNotificationInfo = new NotificationInfo(request.getSmeNotification());
        NotificationInfo smeNotificationInfo = new NotificationInfo();
        smeNotificationInfo = notificationInfoRepo.save(smeNotificationInfo);
        smeNotificationInfo.setNumOfReminders(request.getSmeNotification().getNumOfReminders());
        smeNotificationInfo.addReminders(request.getSmeNotification().getReminders());

//        NotificationInfo onboardingNotificationInfo = new NotificationInfo(request.getOnboardingNotification());
        NotificationInfo onboardingNotificationInfo = new NotificationInfo();
        onboardingNotificationInfo = notificationInfoRepo.save(onboardingNotificationInfo);
        onboardingNotificationInfo.setNumOfReminders(request.getOnboardingNotification().getNumOfReminders());
        onboardingNotificationInfo.addReminders(request.getOnboardingNotification().getReminders());
        Reminder reminder = new Reminder(request.getReportingClearancePeriodicNotification());

        Notification notification = new Notification();
        notification.setSmeNotification(smeNotificationInfo);
        notification.setOnboardingNotification(onboardingNotificationInfo);
        notification.setReportingClearancePeriodicNotification(reminder);

        try {
            notificationInfoRepo.save(smeNotificationInfo);
            notificationInfoRepo.save(onboardingNotificationInfo);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw e;
        }
    }
}

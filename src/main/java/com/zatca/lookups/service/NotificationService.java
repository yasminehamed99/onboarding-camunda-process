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
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
public class NotificationService {

    @Autowired
    private NotificationRepo notificationRepo;

    @Autowired
    private NotificationInfoRepo notificationInfoRepo;

    @Autowired
    private ReminderRepo reminderRepo;

    @Transactional(propagation = Propagation.SUPPORTS)
    public void saveNotificationConfig(NotificationDTO request) {


//        NotificationInfo smeNotificationInfo = new NotificationInfo(request.getSmeNotification());
        NotificationInfo smeNotificationInfo = new NotificationInfo();
        smeNotificationInfo = notificationInfoRepo.save(smeNotificationInfo);
        smeNotificationInfo.setNumOfReminders(request.getSmePortal().getSmePortalAccessRevocationNumberOfReminders());
        smeNotificationInfo.addReminders(request.getSmePortal().getReminders());

//        NotificationInfo onboardingNotificationInfo = new NotificationInfo(request.getOnboardingNotification());
        NotificationInfo onboardingNotificationInfo = new NotificationInfo();
        onboardingNotificationInfo = notificationInfoRepo.save(onboardingNotificationInfo);
        onboardingNotificationInfo.setNumOfReminders(request.getOnBoarding().getSmePortalAccessRevocationNumberOfReminders());
        onboardingNotificationInfo.addReminders(request.getOnBoarding().getReminders());
        Reminder reminder = new Reminder(request.getReportingAndClearance());

        Notification notification = new Notification();
        notification.setSmeNotification(smeNotificationInfo);
        notification.setOnboardingNotification(onboardingNotificationInfo);
        notification.setReportingClearancePeriodicNotification(reminder);

        try {
//            notificationInfoRepo.save(smeNotificationInfo);
//            notificationInfoRepo.save(onboardingNotificationInfo);
            notificationRepo.save(notification);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw e;
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void updateNotificationConfig(NotificationDTO request) {

        notificationRepo.deleteAll();
        notificationInfoRepo.deleteAll();
        reminderRepo.deleteAll();
        saveNotificationConfig(request);

    }

    public NotificationDTO findConfigs() {

        Notification configs = notificationRepo.findAll().get(0);
        NotificationDTO dto = new NotificationDTO();

        dto.getSmePortal().setSmePortalAccessRevocationNumberOfReminders(configs.getSmeNotification().getNumOfReminders());
        dto.getSmePortal().setReminders(dto.getSmePortal().addReminders(configs.getSmeNotification().getReminders()));

        dto.getOnBoarding().setSmePortalAccessRevocationNumberOfReminders(configs.getOnboardingNotification().getNumOfReminders());
        dto.getOnBoarding().setReminders(dto.getOnBoarding().addReminders(configs.getOnboardingNotification().getReminders()));

        dto.getReportingAndClearance().setTimePeriod(configs.getReportingClearancePeriodicNotification().getTimePeriod());
        dto.getReportingAndClearance().setValue(configs.getReportingClearancePeriodicNotification().getValue());

        return dto;
    }

    private List<Reminder> convertReminders(List<com.zatca.lookups.api.v1.dto.notification.Reminder> dtoReminders) {
        List<com.zatca.lookups.entity.configuration.notification.Reminder> entityReminders = new ArrayList<>();
        for (com.zatca.lookups.api.v1.dto.notification.Reminder dtoReminder : dtoReminders) {
            com.zatca.lookups.entity.configuration.notification.Reminder temp = new com.zatca.lookups.entity.configuration.notification.Reminder();
            temp.setTimePeriod(dtoReminder.getTimePeriod());
            temp.setValue(dtoReminder.getValue());
            entityReminders.add(temp);
        }
        return entityReminders;
    }
}

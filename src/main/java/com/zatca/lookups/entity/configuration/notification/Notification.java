package com.zatca.lookups.entity.configuration.notification;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @OneToOne
    @JoinColumn(name = "smeNotification_id")
    private NotificationInfo smeNotification;
    @OneToOne()
    @JoinColumn(name = "onboardingNotification_id", referencedColumnName = "id")
    private NotificationInfo onboardingNotification;
    @OneToOne()
    @JoinColumn(name = "reminder_id", referencedColumnName = "id")
    private Reminder reportingClearancePeriodicNotification;


}

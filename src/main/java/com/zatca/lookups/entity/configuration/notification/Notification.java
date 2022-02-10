package com.zatca.lookups.entity.configuration.notification;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "smeNotification_id")
    private NotificationInfo smeNotification;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "onboardingNotification_id", referencedColumnName = "id")
    private NotificationInfo onboardingNotification;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reminder_id", referencedColumnName = "id")
    private Reminder reportingClearancePeriodicNotification;


}

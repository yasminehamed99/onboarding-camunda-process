package com.zatca.lookups.entity.configuration.notification;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Reminder {

    public Reminder(com.zatca.lookups.api.v1.dto.notification.Reminder dto) {
        value = dto.getValue();
        timePeriod = dto.getTimePeriod();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(name = "value")
    private long value;
    @Column(name = "Time_Period")
    private String timePeriod;

    @ManyToOne()
    @JoinColumn(name = "notification_id")
    private NotificationInfo notificationInfo;

    public void setProperties(com.zatca.lookups.api.v1.dto.notification.Reminder dto) {
        value = dto.getValue();
        timePeriod = dto.getTimePeriod();
    }

}

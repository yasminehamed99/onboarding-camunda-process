package com.zatca.lookups.entity.configuration.notification;

import com.zatca.lookups.api.v1.dto.notification.NotificationInfoDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class NotificationInfo {

    public NotificationInfo(NotificationInfoDTO dto) {
        numOfReminders = dto.getSmePortalAccessRevocationNumberOfReminders();
        List<Reminder> temp = new ArrayList<>();
        for(com.zatca.lookups.api.v1.dto.notification.Reminder reminder : dto.getReminders()) {
            Reminder tempReminder = new Reminder(reminder);
            temp.add(tempReminder);
        }
        reminders = temp;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(name = "Num_Of_Reminders")
    private long numOfReminders;
    @OneToMany(mappedBy = "notificationInfo", cascade = CascadeType.ALL)
    private List<Reminder> reminders;

    public void addReminders(List<com.zatca.lookups.api.v1.dto.notification.Reminder> reminderList) {
        List<Reminder> temp = new ArrayList<>();
        for(com.zatca.lookups.api.v1.dto.notification.Reminder reminder : reminderList) {
            Reminder tempReminder = new Reminder(reminder);
            tempReminder.setNotificationInfo(this);
            temp.add(tempReminder);
        }
        reminders = temp;
    }

}

package dev.kuchishkin.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserNotification {
    private Long id;

    private Long notificationEventId;

    private Long userId;

    private boolean isRead;
}

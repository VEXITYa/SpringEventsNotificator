package dev.kuchishkin.converter;

import dev.kuchishkin.entity.NotificationEventEntity;
import dev.kuchishkin.entity.UserNotificationEntity;
import dev.kuchishkin.model.UserNotification;
import org.springframework.stereotype.Component;

@Component
public class UserNotificationEntityConverter {

    public UserNotification toModel(UserNotificationEntity entity) {
        return new UserNotification(
            entity.getId(),
            entity.getNotificationEvent().getId(),
            entity.getUserId(),
            entity.isRead()
        );
    }

    public UserNotificationEntity toEntity(UserNotification dto) {
        UserNotificationEntity entity = new UserNotificationEntity();
        entity.setId(dto.getId());
        entity.setUserId(dto.getUserId());
        entity.setRead(dto.isRead());

        NotificationEventEntity event = new NotificationEventEntity();
        event.setId(dto.getNotificationEventId());
        entity.setNotificationEvent(event);

        return entity;
    }
}

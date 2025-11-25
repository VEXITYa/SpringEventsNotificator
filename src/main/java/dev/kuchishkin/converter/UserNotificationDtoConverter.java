package dev.kuchishkin.converter;

import dev.kuchishkin.dto.UserNotificationDto;
import dev.kuchishkin.model.UserNotification;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserNotificationDtoConverter {

    public UserNotificationDto toDto(UserNotification model) {
        return new UserNotificationDto(
            model.getId(),
            model.getNotificationEventId(),
            model.getUserId(),
            model.isRead()
        );
    }
}

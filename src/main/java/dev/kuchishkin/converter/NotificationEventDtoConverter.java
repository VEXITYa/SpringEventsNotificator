package dev.kuchishkin.converter;

import dev.kuchishkin.dto.NotificationEventDto;
import dev.kuchishkin.dto.NotificationEventDto.FieldModificationDto;
import dev.kuchishkin.model.NotificationEvent;
import org.springframework.stereotype.Component;

@Component
public class NotificationEventDtoConverter {

    public NotificationEventDto toDto(NotificationEvent notificationEvent) {
        NotificationEventDto dto = new NotificationEventDto();
        dto.setEventId(notificationEvent.getEventId());
        if (notificationEvent.getName() != null) {
            dto.setName(
                new FieldModificationDto<>(
                    notificationEvent.getName().oldField(),
                    notificationEvent.getName().newField()
                )
            );
        }

        if (notificationEvent.getMaxPlaces() != null) {
            dto.setMaxPlaces(
                new FieldModificationDto<>(
                    notificationEvent.getMaxPlaces().oldField(),
                    notificationEvent.getMaxPlaces().newField()
                )
            );
        }

        if (notificationEvent.getDate() != null) {
            dto.setDate(
                new FieldModificationDto<>(
                    notificationEvent.getDate().oldField(),
                    notificationEvent.getDate().newField()
                )
            );
        }

        if (notificationEvent.getCost() != null) {
            dto.setCost(
                new FieldModificationDto<>(
                    notificationEvent.getCost().oldField(),
                    notificationEvent.getCost().newField()
                )
            );
        }

        if (notificationEvent.getDuration() != null) {
            dto.setDuration(
                new FieldModificationDto<>(
                    notificationEvent.getDuration().oldField(),
                    notificationEvent.getDuration().newField()
                )
            );
        }

        if (notificationEvent.getLocationId() != null) {
            dto.setLocationId(
                new FieldModificationDto<>(
                    notificationEvent.getLocationId().oldField(),
                    notificationEvent.getLocationId().newField()
                )
            );
        }

        if (notificationEvent.getEventStatus() != null) {
            dto.setStatus(
                new FieldModificationDto<>(
                    notificationEvent.getEventStatus().oldField().name(),
                    notificationEvent.getEventStatus().newField().name()
                )
            );
        }

        return dto;
    }
}

package dev.kuchishkin.converter;

import dev.kuchishkin.entity.NotificationEventEntity;
import dev.kuchishkin.model.NotificationEvent;
import org.springframework.stereotype.Component;

@Component
public class NotificationEventEntityConverter {

    public NotificationEventEntity toEntity(NotificationEvent message) {
        NotificationEventEntity entity = new NotificationEventEntity();

        entity.setEventId(message.getEventId());
        entity.setOwnerId(message.getOwnerId());
        entity.setChangedById(message.getChangedById());

        if (message.getName() != null) {
            entity.setOldName(message.getName().oldField());
            entity.setNewName(message.getName().newField());
        }

        if (message.getMaxPlaces() != null) {
            entity.setOldMaxPlaces(message.getMaxPlaces().oldField());
            entity.setNewMaxPlaces(message.getMaxPlaces().newField());
        }

        if (message.getDate() != null) {
            entity.setOldDate(message.getDate().oldField());
            entity.setNewDate(message.getDate().newField());
        }

        if (message.getCost() != null) {
            entity.setOldCost(message.getCost().oldField());
            entity.setNewCost(message.getCost().newField());
        }

        if (message.getDuration() != null) {
            entity.setOldDuration(message.getDuration().oldField());
            entity.setNewDuration(message.getDuration().newField());
        }

        if (message.getLocationId() != null) {
            entity.setOldLocationId(message.getLocationId().oldField());
            entity.setNewLocationId(message.getLocationId().newField());
        }

        if (message.getEventStatus() != null) {
            entity.setOldEventStatus(message.getEventStatus().oldField());
            entity.setNewEventStatus(message.getEventStatus().newField());
        }

        return entity;
    }

    public NotificationEvent toModel(NotificationEventEntity entity) {
        NotificationEvent model = new NotificationEvent();

        model.setEventId(entity.getEventId());
        model.setOwnerId(entity.getOwnerId());
        model.setChangedById(entity.getChangedById());

        if (entity.getNewName() != null) {
            entity.setOldName(entity.getOldName());
            entity.setNewName(entity.getNewName());
        }

        if (entity.getNewMaxPlaces() != null) {
            entity.setOldMaxPlaces(entity.getOldMaxPlaces());
            entity.setNewMaxPlaces(entity.getNewMaxPlaces());
        }

        if (entity.getOldDate() != null) {
            entity.setOldDate(entity.getOldDate());
            entity.setNewDate(entity.getNewDate());
        }

        if (entity.getOldCost() != null) {
            entity.setOldCost(entity.getOldCost());
            entity.setNewCost(entity.getNewCost());
        }

        if (entity.getOldDuration() != null) {
            entity.setOldDuration(entity.getOldDuration());
            entity.setNewDuration(entity.getNewDuration());
        }

        if (entity.getOldLocationId() != null) {
            entity.setOldLocationId(entity.getOldLocationId());
            entity.setNewLocationId(entity.getNewLocationId());
        }

        if (entity.getOldEventStatus() != null) {
            entity.setOldEventStatus(entity.getOldEventStatus());
            entity.setNewEventStatus(entity.getNewEventStatus());
        }

        return model;
    }
}

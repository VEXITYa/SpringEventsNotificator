package dev.kuchishkin.model;

import dev.kuchishkin.enums.EventStatus;
import dev.kuchishkin.kafka.FieldModification;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NotificationEvent {

    private Long eventId;
    private Long ownerId;
    private Long changedById;
    private List<Long> users;

    private FieldModification<String> name;
    private FieldModification<Integer> maxPlaces;
    private FieldModification<LocalDateTime> date;
    private FieldModification<Integer> cost;
    private FieldModification<Integer> duration;
    private FieldModification<Long> locationId;
    private FieldModification<EventStatus> eventStatus;
}

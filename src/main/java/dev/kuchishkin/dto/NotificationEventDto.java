package dev.kuchishkin.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NotificationEventDto {

    private Long eventId;

    private FieldModificationDto<String> name;
    private FieldModificationDto<Integer> maxPlaces;
    private FieldModificationDto<LocalDateTime> date;
    private FieldModificationDto<Integer> cost;
    private FieldModificationDto<Integer> duration;
    private FieldModificationDto<Long> locationId;
    private FieldModificationDto<String> status;

    public record FieldModificationDto<T>(
        T oldField,
        T newField
    ) {

    }
}
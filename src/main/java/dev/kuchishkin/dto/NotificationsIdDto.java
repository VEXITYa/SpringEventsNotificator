package dev.kuchishkin.dto;

import jakarta.validation.constraints.NotNull;
import java.util.List;

public record NotificationsIdDto(
    @NotNull
    List<Long> notificationIds
) {

}

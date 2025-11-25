package dev.kuchishkin.controller;

import dev.kuchishkin.converter.UserNotificationDtoConverter;
import dev.kuchishkin.dto.NotificationsIdDto;
import dev.kuchishkin.dto.UserNotificationDto;
import dev.kuchishkin.service.UserNotificationService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notifications")
@RequiredArgsConstructor
@Slf4j
public class UserNotificationController {

    private final UserNotificationService userNotificationService;
    private final UserNotificationDtoConverter userNotificationDtoConverter;

    @GetMapping
    public ResponseEntity<List<UserNotificationDto>> getAllUnread() {
        log.info("Get request for all unread notifications");

        return ResponseEntity.status(HttpStatus.OK)
            .body(
                userNotificationService
                    .findAllUnread()
                    .stream()
                    .map(userNotificationDtoConverter::toDto)
                    .toList()
            );
    }

    @PostMapping
    public ResponseEntity<Void> markAsRead(@RequestBody NotificationsIdDto notificationsIdDto) {
        userNotificationService.markAsRead(notificationsIdDto.notificationIds());
        log.info("Post request for mark as read. NotificationIds: {}", notificationsIdDto.notificationIds());
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
            .build();
    }

}

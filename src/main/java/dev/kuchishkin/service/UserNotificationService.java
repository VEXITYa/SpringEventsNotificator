package dev.kuchishkin.service;

import dev.kuchishkin.converter.UserNotificationEntityConverter;
import dev.kuchishkin.model.UserNotification;
import dev.kuchishkin.repository.UserNotificationRepository;
import dev.kuchishkin.security.jwt.JwtAuthenticationService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserNotificationService {

    private final UserNotificationRepository userNotificationRepository;
    private final UserNotificationEntityConverter userNotificationEntityConverter;
    private final JwtAuthenticationService jwtAuthenticationService;

    public void saveAll(List<UserNotification> userNotifications) {
        userNotificationRepository.saveAll(
            userNotifications
                .stream()
                .map(userNotificationEntityConverter::toEntity)
                .toList()
        );

        log.info("UserNotifications saved");
    }

    public List<UserNotification> findAllUnread() {
        Long userId = jwtAuthenticationService.getCurrentUser().id();

        List<UserNotification> notifications = userNotificationRepository
            .findByUserIdAndIsReadFalse(userId)
            .stream()
            .map(userNotificationEntityConverter::toModel)
            .toList();

        log.info("Find all unread notifications for user {}", userId);

        return notifications;
    }

    public void markAsRead(List<Long> ids) {
        Long userId = jwtAuthenticationService.getCurrentUser().id();

        userNotificationRepository
            .findByIdInAndUserId(ids, userId)
            .forEach(e -> {
                e.setRead(true);
                userNotificationRepository.save(e);
            });

        log.info("Notifications with id: {} marked as read", ids);
    }

    public void deleteReadNotifications() {
        userNotificationRepository.deleteByIsReadTrue();
    }
}

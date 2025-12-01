package dev.kuchishkin.service;

import dev.kuchishkin.converter.NotificationEventEntityConverter;
import dev.kuchishkin.entity.NotificationEventEntity;
import dev.kuchishkin.model.NotificationEvent;
import dev.kuchishkin.model.UserNotification;
import dev.kuchishkin.repository.NotificationEventRepository;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class NotificationEventService {

    private final NotificationEventRepository notificationEventRepository;
    private final UserNotificationService userNotificationService;
    private final NotificationEventEntityConverter notificationEventEntityConverter;

    @Transactional
    public void saveNotification(NotificationEvent notificationEvent) {
        NotificationEventEntity entity = notificationEventEntityConverter.toEntity(
            notificationEvent);
        NotificationEventEntity savedEvent = notificationEventRepository.save(entity);

        List<UserNotification> userNotifications = notificationEvent.getUsers().stream()
            .distinct()
            .map(userId -> {
                UserNotification un = new UserNotification();
                un.setNotificationEventId(savedEvent.getId());
                un.setUserId(userId);
                un.setRead(false);
                return un;
            })
            .toList();

        userNotificationService.saveAll(userNotifications);

        log.info("Saved {} user notifications for event {}", userNotifications.size(),
            savedEvent.getId());
    }

    @Transactional
    public void deleteOldNotificationEvents() {
        LocalDateTime threshold = LocalDateTime.now().minusDays(7);

        List<Long> oldEventIds = notificationEventRepository
            .findIdsByCreatedAtBefore(threshold);

        for (Long id : oldEventIds) {
            notificationEventRepository.deleteById(id);
        }
    }
}

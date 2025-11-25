package dev.kuchishkin.scheduled_events;

import dev.kuchishkin.service.UserNotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
@Configuration
@Slf4j
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class UserNotificationDeleteScheduled {

    private final UserNotificationService userNotificationService;

    @Scheduled(cron = "${event.deleteReadUserNotifications.cron}")
    public void deleteReadNotifications() {
        log.info("Deleting read user notifications");

        userNotificationService.deleteReadNotifications();
    }
}

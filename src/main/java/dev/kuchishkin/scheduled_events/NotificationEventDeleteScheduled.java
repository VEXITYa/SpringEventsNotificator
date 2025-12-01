package dev.kuchishkin.scheduled_events;

import dev.kuchishkin.service.NotificationEventService;
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
public class NotificationEventDeleteScheduled {
    private final NotificationEventService notificationEventService;

    @Scheduled(cron = "${event.deleteOldNotificationEvents.cron}")
    public void deleteOldNotificationEvents(){
        log.info("Deleting old notification events");

        notificationEventService.deleteOldNotificationEvents();
    }
}

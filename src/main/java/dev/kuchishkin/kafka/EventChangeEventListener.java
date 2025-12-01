package dev.kuchishkin.kafka;


import dev.kuchishkin.model.NotificationEvent;
import dev.kuchishkin.service.NotificationEventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class EventChangeEventListener {

    private final NotificationEventService notificationEventService;

    @KafkaListener(topics = "event-change-topic", containerFactory = "containerFactory")
    public void listenEvents(
        ConsumerRecord<Long, NotificationEvent> record
    ) {
        log.info("Kafka: get event={}", record.value());

        notificationEventService.saveNotification(record.value());
    }

}

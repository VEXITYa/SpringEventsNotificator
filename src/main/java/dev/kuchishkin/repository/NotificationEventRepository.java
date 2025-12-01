package dev.kuchishkin.repository;

import dev.kuchishkin.entity.NotificationEventEntity;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationEventRepository extends JpaRepository<NotificationEventEntity, Long> {

    List<Long> findIdsByCreatedAtBefore(LocalDateTime threshold);
}

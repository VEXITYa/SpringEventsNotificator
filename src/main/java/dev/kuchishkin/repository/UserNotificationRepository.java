package dev.kuchishkin.repository;

import dev.kuchishkin.entity.UserNotificationEntity;
import dev.kuchishkin.model.UserNotification;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserNotificationRepository extends JpaRepository<UserNotificationEntity, Long> {

    List<UserNotificationEntity> findByUserIdAndIsReadFalse(Long userId);

    List<UserNotificationEntity> findByIdInAndUserId(List<Long> ids, Long userId);

    void deleteByIsReadTrue();
}

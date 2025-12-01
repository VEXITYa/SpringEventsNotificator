package dev.kuchishkin.entity;

import dev.kuchishkin.enums.EventStatus;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "notification_event")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NotificationEventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long eventId;
    private Long ownerId;
    private Long changedById;

    private String oldName;
    private String newName;
    private Integer oldMaxPlaces;
    private Integer newMaxPlaces;
    private LocalDateTime oldDate;
    private LocalDateTime newDate;
    private Integer oldCost;
    private Integer newCost;
    private Integer oldDuration;
    private Integer newDuration;
    private Long oldLocationId;
    private Long newLocationId;
    private EventStatus oldEventStatus;
    private EventStatus newEventStatus;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @OneToMany(
        mappedBy = "notificationEvent",
        cascade = CascadeType.REMOVE,
        orphanRemoval = true,
        fetch = FetchType.LAZY
    )
    private List<UserNotificationEntity> userNotifications;
}
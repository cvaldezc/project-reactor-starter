package io.chris.reactornotification.repository.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@Table("notification")
public class NotificationEntity {
    @Id
    private Long id;
    private String description;
    private boolean completed;
    @Column("created_at")
    private LocalDateTime createdAt;
}

package io.chris.reactornotification.model;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record Notification(Long id,
                           String description,
                           boolean completed,
                           LocalDateTime createAt) {
}

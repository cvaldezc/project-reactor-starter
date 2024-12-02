package io.chris.reactiveuserreactor.model;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder(toBuilder = true)
public record User(
        Long id,
        String firstName,
        String lastName,
        Integer age,
        Boolean enabled,
        LocalDateTime createdAt,
        LocalDateTime updatedAt) {
}

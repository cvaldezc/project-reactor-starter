package io.chris.reactorstudent.domain.student.model;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder(toBuilder = true)
public record Student(
        Long id,
        String firstName,
        String lastName,
        Integer age,
        String email,
        Boolean active,
        LocalDateTime createdAt,
        LocalDateTime updatedAt) {
}

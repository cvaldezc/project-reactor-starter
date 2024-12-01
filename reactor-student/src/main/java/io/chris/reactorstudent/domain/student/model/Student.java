package io.chris.reactorstudent.domain.student.model;

import lombok.Builder;

@Builder
public record Student(
        Long id,
        String firstName,
        String lastName,
        int age,
        String email
) {
}

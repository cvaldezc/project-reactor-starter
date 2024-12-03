package io.chris.rxproduct.model;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder(toBuilder = true)
public record Product(
        Long id,
        String name,
        LocalDateTime createAt,
        boolean enabled
) {

}

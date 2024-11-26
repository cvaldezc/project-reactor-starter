package io.chris.rxinitserver.async.domain.model;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record Data(Long id, String data, LocalDateTime createTime) {
}

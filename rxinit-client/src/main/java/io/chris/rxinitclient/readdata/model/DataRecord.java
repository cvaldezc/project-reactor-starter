package io.chris.rxinitclient.readdata.model;

import java.time.LocalDateTime;

public record DataRecord(Long id, String data, LocalDateTime createTime) {
}

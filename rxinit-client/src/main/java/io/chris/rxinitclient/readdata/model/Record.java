package io.chris.rxinitclient.readdata.model;

import java.time.LocalDateTime;

public record Record (Long id, String data, LocalDateTime createTime) {
}

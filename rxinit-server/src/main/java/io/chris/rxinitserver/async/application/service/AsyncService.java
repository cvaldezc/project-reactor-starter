package io.chris.rxinitserver.async.application.service;

import io.chris.rxinitserver.async.application.AsyncUseCase;
import io.chris.rxinitserver.async.domain.model.Data;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.LocalDateTime;

public class AsyncService implements AsyncUseCase {

    @Override
    public Flux<Data> getData() {
        return Flux.interval(Duration.ofSeconds(2))
                .map(this::buildData)
                .take(10);
    }

    private Data buildData(Long id) {
        return Data.builder()
                .id(id)
                .data(String.format("Data async %d", id))
                .createTime(LocalDateTime.now()).build();
    }
}

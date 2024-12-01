package io.chris.rxinitclient.readdata.service;

import io.chris.rxinitclient.readdata.model.DataRecord;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@Slf4j
public class ReadAsyncImpl implements ReadDataAsync {

    private static final String URL = "http://localhost:8080";

    @Override
    public Flux<DataRecord> getEachRecord() {
        return getWebClient().get()
                .uri("/async")
                .header("Content-Type", "application/stream+json")
                .retrieve().bodyToFlux(DataRecord.class)
                .doOnNext(data -> log.info("received -> {}", data));
    }

    @Override
    public Mono<List<DataRecord>> getAllRecords() {
        return getWebClient().get()
                .uri("/async")
                .retrieve()
                .bodyToFlux(DataRecord.class)
                .collectList();
    }

    private WebClient getWebClient() {
        return WebClient.create(URL);
    }
}

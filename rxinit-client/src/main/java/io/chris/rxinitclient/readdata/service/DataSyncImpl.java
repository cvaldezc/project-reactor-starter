package io.chris.rxinitclient.readdata.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DataSyncImpl implements ReadDataSync {

    @Override
    public Mono<String> getSingleRecord() {
        return WebClient.create("http://localhost:8080")
                .get().uri("/sync")
                .header(HttpHeaders.ACCEPT, "plain/text")
                .header(HttpHeaders.CONTENT_TYPE, "plain/text")
                .retrieve()
                .bodyToMono(String.class);
    }
}

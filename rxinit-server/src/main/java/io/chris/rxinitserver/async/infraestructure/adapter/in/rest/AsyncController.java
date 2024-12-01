package io.chris.rxinitserver.async.infraestructure.adapter.in.rest;

import io.chris.rxinitserver.async.application.AsyncUseCase;
import io.chris.rxinitserver.async.domain.model.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@Slf4j
@RestController
@RequestMapping("/async")
@RequiredArgsConstructor
public class AsyncController {

    private final AsyncUseCase asyncUseCase;

    @GetMapping(produces = MediaType.APPLICATION_NDJSON_VALUE)
    public Flux<Data> async() {
        return asyncUseCase.getData().log();

    }
}

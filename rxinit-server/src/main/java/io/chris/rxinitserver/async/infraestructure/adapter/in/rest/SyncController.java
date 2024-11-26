package io.chris.rxinitserver.async.infraestructure.adapter.in.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/sync")
public class SyncController {

    @GetMapping
    public Mono<String> sync() {
        return Mono.just("data sync from server");
    }
}

package io.chris.rxinitclient.readdata.service;

import reactor.core.publisher.Mono;

public interface ReadDataSync {

    Mono<String> getSingleRecord();
}

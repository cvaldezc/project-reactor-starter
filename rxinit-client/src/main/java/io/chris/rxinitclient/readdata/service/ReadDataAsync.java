package io.chris.rxinitclient.readdata.service;

import io.chris.rxinitclient.readdata.model.DataRecord;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ReadDataAsync {

    Flux<DataRecord> getEachRecord();

    Mono<List<DataRecord>> getAllRecords();
}

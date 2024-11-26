package io.chris.rxinitserver.async.application;

import io.chris.rxinitserver.async.domain.model.Data;
import reactor.core.publisher.Flux;

public interface AsyncUseCase {

    Flux<Data> getData();
}

package io.chris.reactiveuserreactor.repository;

import io.chris.reactiveuserreactor.model.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SQLRepository {

    Mono<User> save(User user);
    Mono<User> getUser(Long id);
    Flux<User> getUsers();
    Mono<Void> deleteUser(Long id);
}

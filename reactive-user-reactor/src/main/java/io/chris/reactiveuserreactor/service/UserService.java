package io.chris.reactiveuserreactor.service;

import io.chris.reactiveuserreactor.model.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
    Mono<User> create(User user);
    Mono<User> getUser(Long id);
    Flux<User> getUsers();
    Mono<Void> delete(Long id);
}

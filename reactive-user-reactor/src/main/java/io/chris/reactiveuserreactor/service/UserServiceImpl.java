package io.chris.reactiveuserreactor.service;

import io.chris.reactiveuserreactor.model.User;
import io.chris.reactiveuserreactor.repository.SQLRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final SQLRepository repository;

    @Override
    public Mono<User> create(User user) {
        return repository.save(user);
    }

    @Override
    public Mono<User> getUser(Long id) {
        return repository.getUser(id);
    }

    @Override
    public Flux<User> getUsers() {
        return repository.getUsers();
    }

    @Override
    public Mono<Void> delete(Long id) {
        return repository.deleteUser(id);
    }
}

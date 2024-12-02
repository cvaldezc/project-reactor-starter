package io.chris.reactiveuserreactor.repository;

import io.chris.reactiveuserreactor.model.User;
import io.chris.reactiveuserreactor.repository.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class SQLAdapter implements SQLRepository {

    private final UserRepository userRepository;
    private final UserMapper mapper;

    @Override
    public Mono<User> save(User user) {
        var unSaved = mapper.toEntity(user);
        unSaved.setCreatedAt(LocalDateTime.now());
        return Mono.fromCallable(() -> userRepository.save(unSaved))
                .map(mapper::toUser);
    }

    @Override
    public Mono<User> getUser(Long id) {
        var entity = userRepository.findById(id);
        return Mono.fromCallable(entity::get)
                .map(mapper::toUser);
    }

    @Override
    public Flux<User> getUsers() {
        return Flux.fromIterable(userRepository.findAll()).map(mapper::toUser);
    }

    @Override
    public Mono<Void> deleteUser(Long id) {
        return Mono.fromRunnable(() -> userRepository.deleteById(id));
    }
}

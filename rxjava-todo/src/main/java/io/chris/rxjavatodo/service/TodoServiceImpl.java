package io.chris.rxjavatodo.service;

import io.chris.rxjavatodo.model.Todo;
import io.chris.rxjavatodo.repository.TodoRepository;
import io.chris.rxjavatodo.repository.entity.TodoEntity;
import io.chris.rxjavatodo.repository.mapper.TodoEntityMapper;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
@Slf4j
public class TodoServiceImpl implements TodoService {

    private final TodoRepository repository;
    private final TodoEntityMapper mapper;

    @Override
    public Single<Todo> createTask(Todo todo) {
        var unSaved = mapper.toEntity(todo);
        return repository.save(unSaved)
                .map(mapper::toModel);
    }

    @Override
    public Flowable<Todo> getAllTask() {
        return repository.findAll().map(mapper::toModel).delay(3L, TimeUnit.SECONDS);
    }

    @Override
    public Maybe<Todo> markCompleteTask(Long id) {
        return repository.findById(id)
                .doOnEvent((todo, ex) -> setCompleted(todo))
                .flatMap(todo -> {
                    repository.save(todo)
                            .subscribe(s -> log.info("task completed"), e -> log.error("error {}", e));
                    return Maybe.just(todo);
                }).map(mapper::toModel);
    }

    private TodoEntity setCompleted(TodoEntity entity) {
        entity.setCompleted(true);
        return entity;
    }
}

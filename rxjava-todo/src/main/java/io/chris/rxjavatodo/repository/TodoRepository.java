package io.chris.rxjavatodo.repository;

import io.chris.rxjavatodo.repository.entity.TodoEntity;
import org.springframework.data.repository.reactive.RxJava3CrudRepository;

public interface TodoRepository extends RxJava3CrudRepository<TodoEntity, Long> {
}

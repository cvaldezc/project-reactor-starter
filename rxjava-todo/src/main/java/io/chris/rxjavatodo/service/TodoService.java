package io.chris.rxjavatodo.service;

import io.chris.rxjavatodo.model.Todo;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;

public interface TodoService {

    Single<Todo> createTask(Todo todo);

    Flowable<Todo> getAllTask();

    Maybe<Todo> markCompleteTask(Long id);
}

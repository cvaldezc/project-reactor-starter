package io.chris.rxjavatodo.expose.web;

import io.chris.rxjavatodo.model.Todo;
import io.chris.rxjavatodo.service.TodoService;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todo")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Single<Todo> createTask(@RequestBody Todo todo) {
        return todoService.createTask(todo);
    }

    @GetMapping(produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flowable<Todo> getAllTasks() {
        return todoService.getAllTask();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Maybe<Todo> completedTask(@PathVariable("id") Long id) {
        return todoService.markCompleteTask(id);
    }
}

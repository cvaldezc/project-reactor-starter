package io.chris.reactiveuserreactor.expose.web;

import io.chris.reactiveuserreactor.model.User;
import io.chris.reactiveuserreactor.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class AsyncController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<User> createUser(@RequestBody User user) {
        return userService.create(user);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<User> getUser(@PathVariable("id") Long id) {
        return userService.getUser(id);
    }

    @GetMapping(value = "/streaming", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<User> getUsers() {
        return userService.getUsers();
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteUser(@PathVariable("id") Long id) {
        return userService.delete(id);
    }
}

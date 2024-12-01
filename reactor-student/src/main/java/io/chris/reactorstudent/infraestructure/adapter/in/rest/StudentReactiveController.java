package io.chris.reactorstudent.infraestructure.adapter.in.rest;

import io.chris.reactorstudent.aplication.student.ports.ConsultStudentUseCase;
import io.chris.reactorstudent.aplication.student.ports.CreateStudentUseCase;
import io.chris.reactorstudent.aplication.student.ports.DeleteStudentUseCase;
import io.chris.reactorstudent.aplication.student.ports.UpdateStudentUseCase;
import io.chris.reactorstudent.domain.student.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("/async/student")
@RestController
@RequiredArgsConstructor
public class StudentReactiveController {
    private final CreateStudentUseCase createStudentUseCase;
    private final ConsultStudentUseCase consultStudentUseCase;
    private final UpdateStudentUseCase updateStudentUseCase;
    private final DeleteStudentUseCase deleteStudentUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Student> createStudent(@RequestBody Student student) {
        return Mono.from(createStudentUseCase.createAsync(student));
    }

    @GetMapping("/{id}")
    public Mono<Student> getStudent(@PathVariable("id") Long id) {
        return Mono.from(consultStudentUseCase.getStudentAsync(id));
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> updateStudent(@PathVariable("id") Long id, @RequestBody Student student) {
        return Mono.from(updateStudentUseCase.updateStudentAsync(student.toBuilder().id(id).build()));
    }

    @GetMapping(value = "/actives", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Student> getStudents() {
        return Flux.from(consultStudentUseCase.getStudentActivesAsync());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Mono<Void> deleteStudent(@PathVariable("id") Long id) {
        return Mono.from(deleteStudentUseCase.deleteStudentAsync(id));
    }
}

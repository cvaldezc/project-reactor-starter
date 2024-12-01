package io.chris.reactorstudent.infraestructure.adapter.out.sql;

import io.chris.reactorstudent.aplication.student.ports.out.StudentRepositoryAsyncPort;
import io.chris.reactorstudent.aplication.student.ports.out.StudentRepositoryPort;
import io.chris.reactorstudent.domain.student.model.Student;
import lombok.RequiredArgsConstructor;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Component
@RequiredArgsConstructor
public class StudentRepositoryAsyncAdapter implements StudentRepositoryAsyncPort {

    private final StudentRepositoryPort studentRepositoryPort;

    @Override
    public Publisher<Student> save(Student student) {
        return Mono.fromCallable(() -> studentRepositoryPort.save(student));
    }

    @Override
    public Publisher<Student> findById(Long id) {
        return Mono.fromCallable(() -> studentRepositoryPort.findById(id).get());
    }

    @Override
    public Publisher<Void> updateStudent(Student student) {
        return Mono.fromRunnable(() -> studentRepositoryPort.updateStudent(student));
    }

    @Override
    public Publisher<Student> getActiveStudents() {
        return Flux.fromStream(studentRepositoryPort.getActiveStudents().stream())
                .delayElements(Duration.ofSeconds(5L));
    }

    @Override
    public Publisher<Void> delete(Long id) {
        return Mono.fromRunnable(() -> studentRepositoryPort.delete(id));
    }
}

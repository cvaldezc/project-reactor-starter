package io.chris.reactorstudent.aplication.student.service;

import io.chris.reactorstudent.aplication.student.ports.CreateStudentUseCase;
import io.chris.reactorstudent.aplication.student.ports.out.StudentRepositoryAsyncPort;
import io.chris.reactorstudent.aplication.student.ports.out.StudentRepositoryPort;
import io.chris.reactorstudent.domain.student.model.Student;
import org.reactivestreams.Publisher;

public class CreateStudentServiceImpl implements CreateStudentUseCase {

    private final StudentRepositoryPort studentRepositoryPort;
    private final StudentRepositoryAsyncPort studentRepositoryAsyncPort;

    public CreateStudentServiceImpl(StudentRepositoryPort studentRepositoryPort, StudentRepositoryAsyncPort studentRepositoryAsyncPort) {
        this.studentRepositoryPort = studentRepositoryPort;
        this.studentRepositoryAsyncPort = studentRepositoryAsyncPort;
    }

    @Override
    public Student create(Student student) {
        return studentRepositoryPort.save(student);
    }

    @Override
    public Publisher<Student> createAsync(Student student) {
        return studentRepositoryAsyncPort.save(student);
    }
}

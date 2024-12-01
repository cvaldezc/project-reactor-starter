package io.chris.reactorstudent.aplication.student.service;

import io.chris.reactorstudent.aplication.student.ports.ConsultStudentUseCase;
import io.chris.reactorstudent.aplication.student.ports.out.StudentRepositoryAsyncPort;
import io.chris.reactorstudent.aplication.student.ports.out.StudentRepositoryPort;
import io.chris.reactorstudent.domain.student.model.Student;
import org.reactivestreams.Publisher;

import java.util.List;

public class ConsultStudentServiceImpl implements ConsultStudentUseCase {

    private final StudentRepositoryPort studentRepositoryPort;
    private final StudentRepositoryAsyncPort studentRepositoryAsyncPort;

    public ConsultStudentServiceImpl(StudentRepositoryPort studentRepositoryPort, StudentRepositoryAsyncPort studentRepositoryAsyncPort) {
        this.studentRepositoryPort = studentRepositoryPort;
        this.studentRepositoryAsyncPort = studentRepositoryAsyncPort;
    }

    @Override
    public Student getStudent(Long id) {
        return studentRepositoryPort.findById(id).get();
    }

    @Override
    public List<Student> getStudentActives() {
        return studentRepositoryPort.getActiveStudents();
    }

    @Override
    public Publisher<Student> getStudentAsync(Long id) {
        return studentRepositoryAsyncPort.findById(id);
    }

    @Override
    public Publisher<Student> getStudentActivesAsync() {
        return studentRepositoryAsyncPort.getActiveStudents();
    }
}

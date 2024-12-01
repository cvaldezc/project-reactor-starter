package io.chris.reactorstudent.aplication.student.service;

import io.chris.reactorstudent.aplication.student.ports.out.StudentRepositoryAsyncPort;
import io.chris.reactorstudent.aplication.student.ports.out.StudentRepositoryPort;
import io.chris.reactorstudent.aplication.student.ports.UpdateStudentUseCase;
import io.chris.reactorstudent.domain.student.model.Student;
import org.reactivestreams.Publisher;

public class UpdateStudentServiceImpl implements UpdateStudentUseCase {

    private final StudentRepositoryPort studentRepositoryPort;
    private final StudentRepositoryAsyncPort studentRepositoryAsyncPort;

    public UpdateStudentServiceImpl(StudentRepositoryPort studentRepositoryPort, StudentRepositoryAsyncPort studentRepositoryAsyncPort) {
        this.studentRepositoryPort = studentRepositoryPort;
        this.studentRepositoryAsyncPort = studentRepositoryAsyncPort;
    }

    @Override
    public void updateStudent(Student student) {
        studentRepositoryPort.updateStudent(student);
    }

    @Override
    public Publisher<Void> updateStudentAsync(Student student) {
        return studentRepositoryAsyncPort.updateStudent(student);
    }
}

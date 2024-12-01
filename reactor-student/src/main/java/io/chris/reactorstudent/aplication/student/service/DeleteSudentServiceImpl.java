package io.chris.reactorstudent.aplication.student.service;

import io.chris.reactorstudent.aplication.student.ports.DeleteStudentUseCase;
import io.chris.reactorstudent.aplication.student.ports.out.StudentRepositoryAsyncPort;
import io.chris.reactorstudent.aplication.student.ports.out.StudentRepositoryPort;
import org.reactivestreams.Publisher;

public class DeleteSudentServiceImpl implements DeleteStudentUseCase {

    private final StudentRepositoryPort studentRepositoryPort;
    private final StudentRepositoryAsyncPort studentRepositoryAsyncPort;

    public DeleteSudentServiceImpl(StudentRepositoryPort studentRepositoryPort, StudentRepositoryAsyncPort studentRepositoryAsyncPort) {
        this.studentRepositoryPort = studentRepositoryPort;
        this.studentRepositoryAsyncPort = studentRepositoryAsyncPort;
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepositoryPort.delete(id);
    }

    @Override
    public Publisher<Void> deleteStudentAsync(Long id) {
        return studentRepositoryAsyncPort.delete(id);
    }
}

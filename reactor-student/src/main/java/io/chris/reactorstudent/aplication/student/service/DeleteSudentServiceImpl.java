package io.chris.reactorstudent.aplication.student.service;

import io.chris.reactorstudent.aplication.student.ports.DeleteStudentUseCase;
import io.chris.reactorstudent.aplication.student.ports.StudentPort;

public class DeleteSudentServiceImpl implements DeleteStudentUseCase {

    private final StudentPort studentPort;

    public DeleteSudentServiceImpl(StudentPort studentPort) {
        this.studentPort = studentPort;
    }

    @Override
    public void deleteStudent(Long id) {
        studentPort.delete(id);
    }
}

package io.chris.reactorstudent.aplication.student.service;

import io.chris.reactorstudent.aplication.student.ports.StudentPort;
import io.chris.reactorstudent.aplication.student.ports.UpdateStudentUseCase;
import io.chris.reactorstudent.domain.student.model.Student;

public class UpdateStudentServiceImpl implements UpdateStudentUseCase {

    private final StudentPort studentPort;

    public UpdateStudentServiceImpl(StudentPort studentPort) {
        this.studentPort = studentPort;
    }

    @Override
    public void updateStudent(Student student) {
        studentPort.updateStudent(student);
    }

}

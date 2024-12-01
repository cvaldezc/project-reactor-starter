package io.chris.reactorstudent.aplication.student.service;

import io.chris.reactorstudent.aplication.student.ports.CreateStudentUseCase;
import io.chris.reactorstudent.aplication.student.ports.StudentPort;
import io.chris.reactorstudent.domain.student.model.Student;

public class CreateStudentServiceImpl implements CreateStudentUseCase {

    private final StudentPort studentPort;

    public CreateStudentServiceImpl(StudentPort studentPort) {
        this.studentPort = studentPort;
    }

    @Override
    public Student create(Student student) {
        return studentPort.save(student);
    }
}

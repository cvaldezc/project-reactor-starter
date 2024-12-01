package io.chris.reactorstudent.aplication.student.service;

import io.chris.reactorstudent.aplication.student.ports.ConsultStudentUseCase;
import io.chris.reactorstudent.aplication.student.ports.StudentPort;
import io.chris.reactorstudent.domain.student.model.Student;

public class ConsultStudentServiceImpl implements ConsultStudentUseCase {

    private final StudentPort studentPort;

    public ConsultStudentServiceImpl(StudentPort studentPort) {
        this.studentPort = studentPort;
    }

    @Override
    public Student getStudent(Long id) {
        return studentPort.findById(id).get();
    }
}

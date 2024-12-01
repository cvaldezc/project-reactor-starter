package io.chris.reactorstudent.aplication.student.ports;

import io.chris.reactorstudent.domain.student.model.Student;

import java.util.List;

public interface ConsultStudentUseCase {

    Student getStudent(Long id);

    List<Student> getStudentActives();
}

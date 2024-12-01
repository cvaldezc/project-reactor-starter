package io.chris.reactorstudent.aplication.student.ports;

import io.chris.reactorstudent.domain.student.model.Student;

public interface CreateStudentUseCase {

    Student create(Student student);
}

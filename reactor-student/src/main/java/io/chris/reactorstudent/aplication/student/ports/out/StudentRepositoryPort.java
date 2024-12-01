package io.chris.reactorstudent.aplication.student.ports.out;

import io.chris.reactorstudent.domain.student.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepositoryPort {

    Student save(Student student);

    Optional<Student> findById(Long id);

    void updateStudent(Student student);

    List<Student> getActiveStudents();

    void delete(Long id);
}

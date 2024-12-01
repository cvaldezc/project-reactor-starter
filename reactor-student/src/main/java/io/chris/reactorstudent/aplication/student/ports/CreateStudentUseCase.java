package io.chris.reactorstudent.aplication.student.ports;

import io.chris.reactorstudent.domain.student.model.Student;
import org.reactivestreams.Publisher;

public interface CreateStudentUseCase {

    Student create(Student student);
    Publisher<Student> createAsync(Student student);
}

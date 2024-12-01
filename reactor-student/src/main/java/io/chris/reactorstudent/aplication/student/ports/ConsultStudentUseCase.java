package io.chris.reactorstudent.aplication.student.ports;

import io.chris.reactorstudent.domain.student.model.Student;
import org.reactivestreams.Publisher;

import java.util.List;

public interface ConsultStudentUseCase {

    Student getStudent(Long id);
    Publisher<Student> getStudentAsync(Long id);

    List<Student> getStudentActives();
    Publisher<Student> getStudentActivesAsync();
}

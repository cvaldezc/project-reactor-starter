package io.chris.reactorstudent.aplication.student.ports;

import io.chris.reactorstudent.domain.student.model.Student;
import org.reactivestreams.Publisher;


public interface UpdateStudentUseCase {

    void updateStudent(Student student);
    Publisher<Void> updateStudentAsync(Student student);
}

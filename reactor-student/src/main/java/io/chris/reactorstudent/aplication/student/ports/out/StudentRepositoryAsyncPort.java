package io.chris.reactorstudent.aplication.student.ports.out;

import io.chris.reactorstudent.domain.student.model.Student;
import org.reactivestreams.Publisher;

public interface StudentRepositoryAsyncPort {

    Publisher<Student> save(Student student);

    Publisher<Student> findById(Long id);

    Publisher<Void> updateStudent(Student student);

    Publisher<Student> getActiveStudents();

    Publisher<Void> delete(Long id);
}

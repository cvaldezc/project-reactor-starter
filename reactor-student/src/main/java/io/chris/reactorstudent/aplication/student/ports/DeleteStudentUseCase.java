package io.chris.reactorstudent.aplication.student.ports;

import org.reactivestreams.Publisher;

public interface DeleteStudentUseCase {

    void deleteStudent(Long id);
    Publisher<Void> deleteStudentAsync(Long id);
}

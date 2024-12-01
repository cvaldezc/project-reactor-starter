package io.chris.reactorstudent.infraestructure.adapter.data.out;

import io.chris.reactorstudent.aplication.student.ports.StudentPort;
import io.chris.reactorstudent.domain.student.model.Student;
import io.chris.reactorstudent.infraestructure.adapter.data.out.mapper.StudentEntityMapper;
import io.chris.reactorstudent.infraestructure.adapter.data.out.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class StudentRepositoryAdapter implements StudentPort {

    private final StudentRepository studentRepository;
    private final StudentEntityMapper mapper;

    @Override
    public Student save(Student student) {
        var studentResult = studentRepository.save(mapper.toStudentEntity(student));
        return mapper.toStudent(studentResult);
    }

    @Override
    public Optional<Student> findById(Long id) {
        var studentResult = studentRepository.findById(id);
        return studentResult.map(mapper::toStudent);
    }
}

package io.chris.reactorstudent.infraestructure.adapter.data.out;

import io.chris.reactorstudent.aplication.student.ports.StudentPort;
import io.chris.reactorstudent.domain.student.model.Student;
import io.chris.reactorstudent.infraestructure.adapter.data.out.mapper.StudentEntityMapper;
import io.chris.reactorstudent.infraestructure.adapter.data.out.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Override
    public void updateStudent(Student student) {
        var studentOpt = findById(student.id());
        var studentRepo = studentOpt.orElseThrow(() -> new IllegalArgumentException("Student not found"));
        studentRepository.save(mapper.toUpdateEntity(updatedStudent(student, studentRepo)));
    }

    private Student updatedStudent(Student student, Student updatedStudent) {
        return updatedStudent.toBuilder()
                .firstName(mapper.updateIfNotNull(student.firstName(), updatedStudent.firstName()))
                .lastName(mapper.updateIfNotNull(student.lastName(), updatedStudent.lastName()))
                .age(mapper.updateIfNotNull(student.age(), updatedStudent.age()))
                .email(mapper.updateIfNotNull(student.email(), updatedStudent.email()))
                .active(mapper.updateIfNotNull(student.active(), updatedStudent.active()))
                .updatedAt(LocalDateTime.now()).build();
    }

    @Override
    public List<Student> getActiveStudents() {
        return studentRepository.findByActiveIsTrue()
                .stream().map(mapper::toStudent)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        var studentOpt = studentRepository.findById(id);
        var studentRepo = studentOpt.orElseThrow(() -> new IllegalArgumentException("Student not found"));
        studentRepository.delete(studentRepo);
    }
}

package io.chris.reactorstudent.infraestructure.adapter.rest.in;

import io.chris.reactorstudent.aplication.student.ports.ConsultStudentUseCase;
import io.chris.reactorstudent.aplication.student.ports.CreateStudentUseCase;
import io.chris.reactorstudent.aplication.student.ports.DeleteStudentUseCase;
import io.chris.reactorstudent.aplication.student.ports.UpdateStudentUseCase;
import io.chris.reactorstudent.domain.student.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/student")
@RestController
@RequiredArgsConstructor
public class StudentController {

    private final CreateStudentUseCase createStudentUseCase;
    private final ConsultStudentUseCase consultStudentUseCase;
    private final UpdateStudentUseCase updateStudentUseCase;
    private final DeleteStudentUseCase deleteStudentUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student) {
        return createStudentUseCase.create(student);
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable("id") Long id) {
        return consultStudentUseCase.getStudent(id);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateStudent(@PathVariable("id") Long id, @RequestBody Student student) {
        updateStudentUseCase.updateStudent(student.toBuilder().id(id).build());
    }

    @GetMapping("/actives")
    public List<Student> getStudents() {
        return consultStudentUseCase.getStudentActives();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteStudent(@PathVariable("id") Long id) {
        deleteStudentUseCase.deleteStudent(id);
    }
}

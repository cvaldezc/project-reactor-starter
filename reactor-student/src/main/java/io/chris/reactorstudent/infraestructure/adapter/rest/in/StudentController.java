package io.chris.reactorstudent.infraestructure.adapter.rest.in;

import io.chris.reactorstudent.aplication.student.ports.ConsultStudentUseCase;
import io.chris.reactorstudent.aplication.student.ports.CreateStudentUseCase;
import io.chris.reactorstudent.domain.student.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/student")
@RestController
@RequiredArgsConstructor
public class StudentController {

    private final CreateStudentUseCase createStudentUseCase;
    private final ConsultStudentUseCase consultStudentUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Student createStudent(@RequestBody Student student) {
        return createStudentUseCase.create(student);
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable("id") Long id) {
        return consultStudentUseCase.getStudent(id);
    }
}
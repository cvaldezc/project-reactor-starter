package io.chris.reactorstudent.infraestructure.config;

import io.chris.reactorstudent.aplication.student.ports.ConsultStudentUseCase;
import io.chris.reactorstudent.aplication.student.ports.CreateStudentUseCase;
import io.chris.reactorstudent.aplication.student.ports.DeleteStudentUseCase;
import io.chris.reactorstudent.aplication.student.ports.StudentPort;
import io.chris.reactorstudent.aplication.student.ports.UpdateStudentUseCase;
import io.chris.reactorstudent.aplication.student.service.ConsultStudentServiceImpl;
import io.chris.reactorstudent.aplication.student.service.CreateStudentServiceImpl;
import io.chris.reactorstudent.aplication.student.service.DeleteSudentServiceImpl;
import io.chris.reactorstudent.aplication.student.service.UpdateStudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigBean {

    @Bean
    public CreateStudentUseCase createStudentUseCase(@Autowired StudentPort studentPort) {
        return new CreateStudentServiceImpl(studentPort);
    }

    @Bean
    public ConsultStudentUseCase consultStudentUseCase(@Autowired StudentPort studentPort) {
        return new ConsultStudentServiceImpl(studentPort);
    }

    @Bean
    public UpdateStudentUseCase updateStudentUseCase(@Autowired StudentPort studentPort) {
        return new UpdateStudentServiceImpl(studentPort);
    }

    @Bean
    public DeleteStudentUseCase deleteStudentUseCase(@Autowired StudentPort studentPort) {
        return new DeleteSudentServiceImpl(studentPort);
    }

}

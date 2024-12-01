package io.chris.reactorstudent.infraestructure.config;

import io.chris.reactorstudent.aplication.student.ports.ConsultStudentUseCase;
import io.chris.reactorstudent.aplication.student.ports.CreateStudentUseCase;
import io.chris.reactorstudent.aplication.student.ports.DeleteStudentUseCase;
import io.chris.reactorstudent.aplication.student.ports.UpdateStudentUseCase;
import io.chris.reactorstudent.aplication.student.ports.out.StudentRepositoryAsyncPort;
import io.chris.reactorstudent.aplication.student.ports.out.StudentRepositoryPort;
import io.chris.reactorstudent.aplication.student.service.ConsultStudentServiceImpl;
import io.chris.reactorstudent.aplication.student.service.CreateStudentServiceImpl;
import io.chris.reactorstudent.aplication.student.service.DeleteSudentServiceImpl;
import io.chris.reactorstudent.aplication.student.service.UpdateStudentServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigBean {

    @Bean
    public CreateStudentUseCase createStudentUseCase(StudentRepositoryPort studentRepositoryPort, StudentRepositoryAsyncPort asyncPort) {
        return new CreateStudentServiceImpl(studentRepositoryPort, asyncPort);
    }

    @Bean
    public ConsultStudentUseCase consultStudentUseCase(StudentRepositoryPort studentRepositoryPort, StudentRepositoryAsyncPort asyncPort) {
        return new ConsultStudentServiceImpl(studentRepositoryPort, asyncPort);
    }

    @Bean
    public UpdateStudentUseCase updateStudentUseCase(StudentRepositoryPort studentRepositoryPort, StudentRepositoryAsyncPort asyncPort) {
        return new UpdateStudentServiceImpl(studentRepositoryPort, asyncPort);
    }

    @Bean
    public DeleteStudentUseCase deleteStudentUseCase(StudentRepositoryPort studentRepositoryPort, StudentRepositoryAsyncPort asyncPort) {
        return new DeleteSudentServiceImpl(studentRepositoryPort, asyncPort);
    }

}

package io.chris.reactorstudent.infraestructure.adapter.data.out.mapper;

import io.chris.reactorstudent.domain.student.model.Student;
import io.chris.reactorstudent.infraestructure.adapter.data.out.entity.StudentEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface StudentEntityMapper {

    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "updatedAt", ignore = true)
    StudentEntity toStudentEntity(Student student);

    @InheritInverseConfiguration
    Student toStudent(StudentEntity studentEntity);
}

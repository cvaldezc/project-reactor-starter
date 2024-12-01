package io.chris.reactorstudent.infraestructure.adapter.data.out.mapper;

import io.chris.reactorstudent.domain.student.model.Student;
import io.chris.reactorstudent.infraestructure.adapter.data.out.entity.StudentEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface StudentEntityMapper {

    @Mapping(target = "active", expression = "java(true)")
    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "updatedAt", ignore = true)
    StudentEntity toStudentEntity(Student student);

    StudentEntity toUpdateEntity(Student student);

    @InheritInverseConfiguration(name = "toStudentEntity")
    Student toStudent(StudentEntity studentEntity);

    @Named("updateIfNotNull")
    default <T> T updateIfNotNull(T newValue, T oldValue) {
        return newValue != null ? newValue : oldValue;
    }
}

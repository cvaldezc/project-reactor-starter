package io.chris.rxjavatodo.repository.mapper;

import io.chris.rxjavatodo.model.Todo;
import io.chris.rxjavatodo.repository.entity.TodoEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface TodoEntityMapper {

    TodoEntity toEntity(Todo todo);

    @InheritInverseConfiguration
    Todo toModel(TodoEntity entity);
}

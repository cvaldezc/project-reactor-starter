package io.chris.reactiveuserreactor.repository.mapper;

import io.chris.reactiveuserreactor.model.User;
import io.chris.reactiveuserreactor.repository.entity.UserEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface UserMapper {

    UserEntity toEntity(User user);

    @InheritInverseConfiguration
    User toUser(UserEntity userEntity);
}

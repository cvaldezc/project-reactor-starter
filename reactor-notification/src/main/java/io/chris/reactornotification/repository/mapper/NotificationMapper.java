package io.chris.reactornotification.repository.mapper;

import io.chris.reactornotification.model.Notification;
import io.chris.reactornotification.repository.entity.NotificationEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface NotificationMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    NotificationEntity toEntity(Notification notification);

    @InheritInverseConfiguration
    Notification toModel(NotificationEntity notificationEntity);
}

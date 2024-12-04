package io.chris.reactornotification.repository;

import io.chris.reactornotification.repository.entity.NotificationEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface NotificationRepository extends ReactiveCrudRepository<NotificationEntity, Long> {
    Flux<NotificationEntity> findByCompletedIs(boolean completed);
}

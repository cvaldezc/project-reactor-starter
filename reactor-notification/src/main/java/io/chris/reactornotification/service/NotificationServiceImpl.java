package io.chris.reactornotification.service;

import io.chris.reactornotification.model.Notification;
import io.chris.reactornotification.repository.NotificationRepository;
import io.chris.reactornotification.repository.mapper.NotificationMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.LocalDateTime;

@Service
@Slf4j
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;
    private final NotificationMapper notificationMapper;

    public NotificationServiceImpl(NotificationRepository notificationRepository, NotificationMapper notificationMapper) {
        this.notificationRepository = notificationRepository;
        this.notificationMapper = notificationMapper;
    }

    @Override
    public Mono<Void> createNotification(Notification notification) {
        return Mono.justOrEmpty(notification)
                .map(notificationMapper::toEntity)
                .flatMap(notificationRepository::save)
                // .doOnNext(item -> log.info("save item: {}", item))
                .then();
    }

    @Override
    public Flux<Notification> getNotifications() {
        return notificationRepository.findByCompletedIs(true)
                .zipWith(Flux.interval(Duration.ofSeconds(2L)), (s1, s2) -> s1)
                .map(notificationMapper::toModel)
                .log("Notification")
                .onBackpressureBuffer(5);
    }
}

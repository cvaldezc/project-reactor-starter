package io.chris.reactornotification.service;

import io.chris.reactornotification.model.Notification;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface NotificationService {

    Mono<Void> createNotification(Notification notification);

    Flux<Notification> getNotifications();
}

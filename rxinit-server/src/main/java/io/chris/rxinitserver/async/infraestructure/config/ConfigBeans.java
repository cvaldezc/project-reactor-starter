package io.chris.rxinitserver.async.infraestructure.config;

import io.chris.rxinitserver.async.application.AsyncUseCase;
import io.chris.rxinitserver.async.application.service.AsyncService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigBeans {

    @Bean
    public AsyncUseCase asyncUseCase() {
        return new AsyncService();
    }

}

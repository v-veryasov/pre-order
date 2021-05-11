package ru.edu.iorder.gateway.config;

import feign.RequestInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class AppConfig {

    @Bean
    public RequestInterceptor requestLoggingInterceptor() {

        return template -> {
            log.info("Adding header [testHeader / testHeaderValue] to request");
            template.header("testHeader", "testHeaderValue");
        };
    }
}
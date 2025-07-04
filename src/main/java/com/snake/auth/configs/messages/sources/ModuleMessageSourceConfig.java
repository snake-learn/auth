package com.snake.auth.configs.messages.sources;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.annotation.Order;

import java.nio.charset.StandardCharsets;
import java.util.Locale;

@Slf4j
@Configuration
public class ModuleMessageSourceConfig {

    @Bean
    @Order(10)
    public MessageSource fileMessageSource() {
        log.info("=== DEFAULT FILE RESOURCE LOCALE: {} ===", Locale.getDefault());
        ResourceBundleMessageSource rs = new ResourceBundleMessageSource();
        rs.setBasenames(
                "messages",
                "CoreMessages",
                "ValidationMessages"
        );
        rs.setDefaultEncoding(StandardCharsets.UTF_8.name());
        rs.setUseCodeAsDefaultMessage(Boolean.FALSE);
        return rs;
    }

    @Bean
    @Order(20)
    public MessageSource getDataMessageSource() {
        return new DatabaseMessageSource();
    }
}

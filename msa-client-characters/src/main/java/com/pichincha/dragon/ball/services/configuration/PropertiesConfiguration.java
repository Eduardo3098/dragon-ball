package com.pichincha.dragon.ball.services.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties
public class PropertiesConfiguration {
    @Value("${application.CLIENT_BASE_URL}")
    private String clientBaseUrl;
}

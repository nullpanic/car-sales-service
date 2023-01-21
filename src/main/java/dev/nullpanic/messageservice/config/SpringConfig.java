package dev.nullpanic.messageservice.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("dev.nullpanic.messageservice")
@PropertySource("classpath:application.properties")
public class SpringConfig {
}

package dev.nullpanic.messageservice;

import dev.nullpanic.messageservice.config.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MessageServiceApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    }
}

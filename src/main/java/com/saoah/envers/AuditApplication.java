package com.saoah.envers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AuditApplication {
    public static void main(String[] args) {
        new SpringApplication().run(AuditApplication.class, args);
    }
}

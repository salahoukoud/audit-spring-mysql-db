package com.saoah.envers.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan
@Import({PersistenceConfig.class, AuditConfig.class})
public class ApplicationConfig {

}

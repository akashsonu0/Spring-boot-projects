package com.app.akash.config;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "com.app.akash")
@Import(PersistenceConfig.class)
public class AppConfig {
	
}
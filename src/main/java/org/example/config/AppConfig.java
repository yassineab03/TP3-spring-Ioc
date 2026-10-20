package org.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {"org.example.dao", "org.example.metier"})
@PropertySource("classpath:app.properties")
public class AppConfig {

}
package org.example.config;

import org.example.dao.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan(basePackages = {"org.example.metier"})
@PropertySource("classpath:app.properties")
public class DynamicDaoConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Value("${dao.target:dao}")
    private String daoTarget;

    @Bean
    public IDao dynamicDao() {
        switch (daoTarget) {
            case "dao":     return new DaoImpl();
            case "dao2":    return new DaoImpl2();
            case "daoFile": return new DaoFile();
            case "daoApi":  return new DaoApi();
            default: throw new IllegalArgumentException("Cible DAO inconnue: " + daoTarget);
        }
    }
}
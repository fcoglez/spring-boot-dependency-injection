package com.springboot.inyencciondependencia.app.springboot.inyencciondependencia;

import com.springboot.inyencciondependencia.app.springboot.inyencciondependencia.repositories.IProductRepository;
import com.springboot.inyencciondependencia.app.springboot.inyencciondependencia.repositories.ProductJsonRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.IOException;

@Configuration
@PropertySource("classpath:config.properties")
public class AppConfig {

    @Bean
    public IProductRepository productJsonRepository() {
        try {
            return new ProductJsonRepository();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

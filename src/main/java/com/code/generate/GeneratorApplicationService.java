package com.code.generate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class GeneratorApplicationService {

    public static void main(String[] args) {
        SpringApplication.run(GeneratorApplicationService.class);
    }
}

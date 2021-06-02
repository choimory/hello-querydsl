package com.practice.helloquerydsl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class HelloQuerydslApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloQuerydslApplication.class, args);
    }

}

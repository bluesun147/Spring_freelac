package com.example.freelec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@EnableJpaAuditing // JPA Auditin 활성화 (시간 자동 기록)
public class FreelecApplication {

    public static void main(String[] args) {
        SpringApplication.run(FreelecApplication.class, args);
    }
}

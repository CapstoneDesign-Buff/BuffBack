package com.project.capsback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class CapsBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(CapsBackApplication.class, args);
    }

}

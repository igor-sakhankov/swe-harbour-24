package com.harbour;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TeacherConfiguration {

    @Bean
    SoftwareEngineeringTeacher teacher() {
        return new SoftwareEngineeringTeacher();
    }
}

package com.harbour;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;

@ComponentScan("com.harbour")
public class PetConfiguration {

    @Bean
    @Primary
    public Dog dog1() {
        return new Dog(1);
    }

    @Bean
    public Dog dog() {
        return new Dog(0);
    }
}

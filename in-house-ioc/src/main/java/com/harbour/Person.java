package com.harbour;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Getter
public class Person {
    private final Dog dog;

    @Autowired
    Person(Dog dog) {
        this.dog = dog;
    }
}
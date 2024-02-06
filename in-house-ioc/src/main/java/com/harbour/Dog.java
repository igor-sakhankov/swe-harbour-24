package com.harbour;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
public class Dog {

    private final int i;

    public Dog(int i) {
        this.i = i;
        System.out.println("I'm a dog!");
    }


    public void bark() {
        System.out.println("Bark!");
    }
}

package com.harbour;

import com.harbour.inhouseinfra.ObjectFactory;

public class Main {
    public static void main(String[] args) {


        ObjectFactory objectFactory = ObjectFactory.getInstance();
        ClassOrganizer classOrganizer = objectFactory.create(ClassOrganizer.class);
        classOrganizer.conductTheClass();

    }
}
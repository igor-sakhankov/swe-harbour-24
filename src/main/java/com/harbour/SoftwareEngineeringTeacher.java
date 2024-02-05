package com.harbour;

public class SoftwareEngineeringTeacher implements Teacher{
    public SoftwareEngineeringTeacher() {
        System.out.println("SoftwareEngineeringTeacher is created");
    }
    @Override
    public void askQuestion(String question) {
        System.out.println("My dear students, " + question);
    }
}

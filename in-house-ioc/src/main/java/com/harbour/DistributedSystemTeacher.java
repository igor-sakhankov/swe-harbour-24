package com.harbour;

public class DistributedSystemTeacher implements Teacher{
    public DistributedSystemTeacher(SoftwareEngineeringTeacher teacher) {
        System.out.println("DistributedSystemTeacher is created");
    }
    @Override
    public void askQuestion(String question) {
        System.out.println("My dear students, " + question);
    }
}

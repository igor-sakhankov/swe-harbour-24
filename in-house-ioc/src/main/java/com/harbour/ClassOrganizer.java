package com.harbour;

import com.harbour.inhouseinfra.InjectByType;

public class ClassOrganizer {
    @InjectByType
    Teacher teacher;
    @InjectByType
    Logger logger;
    @InjectByType
    WeeklyPrize weeklyPrize;

    public void conductTheClass() {
        teacher.askQuestion("why are you late");
        logger.log("question was asked");
        classIsDone();
        System.out.println(weeklyPrize.getPrize());
    }

    private void classIsDone() {
        System.out.println("Class is being conducted");
    }
}

package com.harbour;

import com.harbour.inhouseinfra.InjectProperty;

public class WeeklyPrize {
    @InjectProperty(value = "my_prize")
    private String prize;

    public String getPrize() {
        return prize;
    }
}

package com.harbour;

public class TelegramLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println("LOG:" + message);
    }
}

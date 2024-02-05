package com.harbour;

import com.harbour.inhouseinfra.Singleton;

@Singleton
public interface Logger {

    void log(String message);
}

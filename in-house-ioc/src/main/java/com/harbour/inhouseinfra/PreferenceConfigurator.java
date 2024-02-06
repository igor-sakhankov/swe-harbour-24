package com.harbour.inhouseinfra;

import com.harbour.Logger;
import com.harbour.TelegramLogger;

import java.util.Map;

public class PreferenceConfigurator {
    Map<Class, Class> map = Map.of(Logger.class, TelegramLogger.class);
}

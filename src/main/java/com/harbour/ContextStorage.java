package com.harbour;

import com.harbour.inhouseinfra.ObjectFactory;
import com.harbour.inhouseinfra.Singleton;

import java.util.HashMap;
import java.util.Map;

public class ContextStorage {
    private final Map<Class, Object> context = new HashMap<>();

    public <T> T get(Class<T> clazz) {
        if (clazz.getAnnotation(Singleton.class) == null) {
            return ObjectFactory.getInstance().create(clazz);
        }
        return (T) context.computeIfAbsent(clazz, k -> ObjectFactory.getInstance().create(clazz));
    }
}

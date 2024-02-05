package com.harbour.inhouseinfra;

import lombok.SneakyThrows;

import java.lang.reflect.Field;

public class InjectTypeConfigurator implements ObjectConfigurator{
    @Override
    @SneakyThrows
    public void configure(Object t) {
        for (Field field : t.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(InjectByType.class)) {
                field.setAccessible(true);
                Object object = ObjectFactory.getInstance().create(field.getType());
                field.set(t, object);
            }
        }
    }
}

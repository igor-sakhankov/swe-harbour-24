package com.harbour.inhouseinfra;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public class InjectPropertyConfigurator implements ObjectConfigurator {
    @Override
    @SneakyThrows
    public void configure(Object t) {
        for (Field field : t.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(InjectProperty.class)) {
                field.setAccessible(true);
                if(field.getAnnotation(InjectProperty.class).value().isBlank()){
                    field.set(t, readProperties(field.getName()));
                }
                else{
                    field.set(t, readProperties(t).get(field.getAnnotation(InjectProperty.class).value()));
                }
            }
        }
    }

    private static Map<String, String> readProperties(Object t) throws FileNotFoundException {
        URL resource = ClassLoader.getSystemClassLoader().getResource("application.properties");
        Stream<String> lines = new BufferedReader(new FileReader(resource.getPath())).lines();
        return lines
                .map(line -> line.split("="))
                .collect(toMap(line -> line[0], line -> line[1]));
    }

}

package com.harbour.inhouseinfra;

import lombok.SneakyThrows;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;

public class ObjectFactory {

    private static ObjectFactory objectFactory = new ObjectFactory();
    private final Reflections scanner;
    private final PreferenceConfigurator preferenceConfigurator;

    public ObjectFactory() {
        this.scanner = new Reflections("com.harbour");
        this.preferenceConfigurator = new PreferenceConfigurator();
    }

    public static ObjectFactory getInstance() {
        return objectFactory;
    }

    @SneakyThrows
    public <T> T create(Class<T> clazz) {
        if(preferenceConfigurator.map.containsKey(clazz))
            clazz = (Class<T>) preferenceConfigurator.map.get(clazz);

        T newInstance = getInstanceFromInterface(clazz);
        if (newInstance == null)
            newInstance = clazz.getDeclaredConstructor().newInstance();

        initializeObject(newInstance);
        return newInstance;
    }

    @SneakyThrows
    private <T> void initializeObject(T newInstance) {
        for (Class<? extends ObjectConfigurator> configurator : scanner.getSubTypesOf(ObjectConfigurator.class)) {
            ObjectConfigurator objectConfigurator = configurator.getDeclaredConstructor().newInstance();
            objectConfigurator.configure(newInstance);
        }

    }

    private <T> T getInstanceFromInterface(Class<T> clazz) throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        if (!clazz.isInterface()) {
            return null;
        }
        return scanner.getSubTypesOf(clazz).stream()
                .findFirst()
                .orElseThrow()
                .getDeclaredConstructor()
                .newInstance();
    }
}

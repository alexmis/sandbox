package org.mial.training.reflections;

import java.lang.reflect.Method;

public class ObjectFactory {
    private static ObjectFactory factory = new ObjectFactory();

    public static ObjectFactory getInstance() {
        return factory;
    }

    private ObjectFactory() {
    }

    public <T> T createObject(Class<T> type) throws Exception {
        final T t = type.newInstance();

        for (Method method : type.getMethods()) {
            final RunThisMethod repeat = method.getAnnotation(RunThisMethod.class);

            if (repeat != null) {
                for (int i = 0; i < repeat.repeat(); i++) {
                    method.invoke(t);
                }
            }
        }
        return null;
    }
}

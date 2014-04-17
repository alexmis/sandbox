package org.mial.training.reflections;

import org.mial.training.annotation.InvokeThisMethod;

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
            final InvokeThisMethod repeat = method.getAnnotation(InvokeThisMethod.class);

            if (repeat != null) {
                for (int i = 0; i < repeat.repeat(); i++) {
                    method.invoke(t);
                }
            }
        }
        return null;
    }
}

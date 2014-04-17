package org.mial.training.bpp;

import org.mial.training.annotation.RunThisMethod;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;

public class RunThisMethodBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        final Method[] methods = bean.getClass().getMethods();

        for (Method method : methods) {
            final RunThisMethod annotation = method.getAnnotation(RunThisMethod.class);
            if (annotation != null) {
                ReflectionUtils.invokeMethod(method, bean);
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
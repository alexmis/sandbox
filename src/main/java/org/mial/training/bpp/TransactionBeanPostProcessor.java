package org.mial.training.bpp;

import org.mial.training.annotation.Transactional;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TransactionBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        final Class<?> type = bean.getClass();
        final Method[] methods = type.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Transactional.class)) {
                return Proxy.newProxyInstance(type.getClassLoader(), type.getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Method classMethod = type.getMethod(method.getName(), method.getParameterTypes());
                        if (classMethod.isAnnotationPresent(Transactional.class)) {
                            System.out.println("*****TRANSACTION OPENED************");
                            final Object retVal = ReflectionUtils.invokeMethod(method, bean, args);
                            System.out.println("*****TRANSACTION CLOSED*************");
                            return retVal;
                        } else {
                            return ReflectionUtils.invokeMethod(method, bean, args);
                        }
                    }
                });
            }
        }
        return bean;
    }
}

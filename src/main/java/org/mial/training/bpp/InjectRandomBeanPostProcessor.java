package org.mial.training.bpp;

import org.mial.training.annotation.InjectRandomInt;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Random;

public class InjectRandomBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        final Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields) {
            InjectRandomInt injectRandom = field.getAnnotation(InjectRandomInt.class);
            if (injectRandom != null) {
                Random random = new Random(System.currentTimeMillis());
                int randomNumber = random.nextInt(injectRandom.max() - injectRandom.min() - 1) + injectRandom.min();

                field.setAccessible(true);
                ReflectionUtils.setField(field, bean, randomNumber);
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}

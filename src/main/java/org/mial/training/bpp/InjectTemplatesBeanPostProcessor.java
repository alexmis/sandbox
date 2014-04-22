package org.mial.training.bpp;

import org.mial.training.mail.InjectTemplates;
import org.mial.training.mail.MailGenerator;
import org.mial.training.mail.MailTemplate;
import org.mial.training.mail.MailTemplateEnum;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;

@Component
public class InjectTemplatesBeanPostProcessor implements BeanPostProcessor {

    @Autowired
    private ApplicationContext context;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(InjectTemplates.class)) {
                field.setAccessible(true);
                Collection<Object> beans = context.getBeansWithAnnotation(MailTemplate.class).values();
                HashMap<MailTemplateEnum, MailGenerator> mapToInject = new HashMap<>();
                for (Object mailGenerator : beans) {
                    MailTemplate annotation = mailGenerator.getClass().getAnnotation(MailTemplate.class);
                    mapToInject.put(annotation.value(), (MailGenerator) mailGenerator);
                }
                ReflectionUtils.setField(field, bean, mapToInject);
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}

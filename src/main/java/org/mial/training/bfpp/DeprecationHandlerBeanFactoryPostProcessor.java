package org.mial.training.bfpp;

import org.mial.training.annotation.DeprecatedClass;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class DeprecationHandlerBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        final String[] definitionNames = beanFactory.getBeanDefinitionNames();

        for (String name : definitionNames) {
            final BeanDefinition definition = beanFactory.getBeanDefinition(name);
            final String beanClassName = definition.getBeanClassName();

            try {
                final Class<?> originClass = Class.forName(beanClassName);
                DeprecatedClass annotation = originClass.getAnnotation(DeprecatedClass.class);
                if (annotation != null) {
                    final Class newImpl = annotation.newImpl();
                    definition.setBeanClassName(newImpl.getName());
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}

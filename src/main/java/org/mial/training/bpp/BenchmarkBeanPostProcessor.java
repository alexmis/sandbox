package org.mial.training.bpp;

import org.mial.training.annotation.Benchmark;
import org.mial.training.bpp.benchmark.BenchmarkFlag;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BenchmarkBeanPostProcessor implements BeanPostProcessor {

    private BenchmarkFlag flag;

    public BenchmarkBeanPostProcessor() throws Exception {
        flag = new BenchmarkFlag();
        flag.setEnabled(true);

        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        mBeanServer.registerMBean(flag, new ObjectName("benchmark", "name", "benchmarkFlag"));
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        final Class<?> type = bean.getClass();
        if (type.getAnnotation(Benchmark.class) != null) {
            return Proxy.newProxyInstance(type.getClassLoader(), type.getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    if (flag.isEnabled()) {
                        System.out.println("************BENCHMARK****************");
                        long before = System.nanoTime();
                        Object retVal = ReflectionUtils.invokeMethod(method, bean, args);
                        System.out.println(System.nanoTime() - before);
                        System.out.println("************BENCHMARK****************");
                        return retVal;
                    } else {
                        return ReflectionUtils.invokeMethod(method, bean, args);
                    }
                }
            });
        }

        return bean;
    }
}

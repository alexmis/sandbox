package org.mial.training.bpp.configurer;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.mial.training.annotation.Benchmark;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BenchmarkObjectConfigurer implements ObjectConfigurer {

    @Override
    public <T, E extends T> E configure(final T t, final Class<T> originalClass) throws Exception {
        Method[] methods = originalClass.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Benchmark.class)) {
                if (originalClass.getInterfaces().length == 0) {
                    return (E) Enhancer.create(originalClass, null, new MethodInterceptor() {
                        @Override
                        public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                            Method originalClassMethod = originalClass.getMethod(method.getName(), method.getParameterTypes());
                            if (originalClassMethod.isAnnotationPresent(Benchmark.class)) {
                                System.out.println("***********BENCHMARK*************");
                                long before = System.nanoTime();
                                Object retVal = method.invoke(t, args);
                                long after = System.nanoTime();
                                System.out.println(after - before);
                                System.out.println("***********BENCHMARK*************");
                                return retVal;
                            } else {
                                return method.invoke(t, args);
                            }
                        }
                    });
                }
                return (E) Proxy.newProxyInstance(originalClass.getClassLoader(), originalClass.getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Method originalClassMethod = originalClass.getMethod(method.getName(), method.getParameterTypes());
                        if (originalClassMethod.isAnnotationPresent(Benchmark.class)) {
                            System.out.println("***********BENCHMARK*************");
                            long before = System.nanoTime();
                            Object retVal = method.invoke(t, args);
                            long after = System.nanoTime();
                            System.out.println(after - before);
                            System.out.println("***********BENCHMARK*************");
                            return retVal;
                        } else {
                            return method.invoke(t, args);
                        }
                    }
                });
            }
        }


        return (E) t;
    }
}

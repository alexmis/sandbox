package org.mial.training.bpp.configurer;

public interface ObjectConfigurer {

    <T, E extends T> E configure(final T t, final Class<T> originalClass) throws Exception;
}

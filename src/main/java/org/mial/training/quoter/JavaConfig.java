package org.mial.training.quoter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan(
        basePackages = {
                "org.mial.training.bfpp",
                "org.mial.training.bpp",
                "org.mial.training.quoter",
                "org.mial.training.robot"})
@PropertySource("classpath:quoters.properties")
public class JavaConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer configurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}

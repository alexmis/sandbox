package org.mial.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
//@ComponentScan(basePackages = {""})
@EnableWebMvc
//@ImportResource("classpath:applicationContext.xml")
//@PropertySource("classpath:application.properties")
public class ApplicationContext {
}

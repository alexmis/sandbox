package org.mial.training.magic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("magic-context.xml");
        Person person = context.getBean(Person.class);
        System.out.println(person);
    }
}

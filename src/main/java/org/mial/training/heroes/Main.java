package org.mial.training.heroes;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("hero-context.xml");

        for (int i = 0; i < 10; i++) {
            Dwarf dwarf = context.getBean(Dwarf.class);
            System.out.println("dwarf: " + dwarf);
        }
    }
}

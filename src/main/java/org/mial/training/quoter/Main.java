package org.mial.training.quoter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("iter1-context.xml");
        final Collection<Quoter> quoters = context.getBeansOfType(Quoter.class).values();

        for (Quoter quoter : quoters) {
            quoter.sayQuote();
        }
    }
}

package org.mial.training.dataart;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        DataartService dataartService = context.getBean(DataartService.class);
        dataartService.load();
        dataartService.save();
    }
}

package org.mial.training.quoter;

import org.mial.training.robot.TalkingRobot;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        context.getBean(TalkingRobot.class).talk();
    }
}

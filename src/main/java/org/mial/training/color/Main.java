package org.mial.training.color;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        final ApplicationContext context = new ClassPathXmlApplicationContext("color-context.xml");

        JFrame frame = new JFrame();
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.getContentPane().setBackground(context.getBean(Color.class));
    }
}

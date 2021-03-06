package org.mial.training.quoter.impl;

import org.mial.training.annotation.InjectRandomInt;
import org.mial.training.annotation.RunThisMethod;
import org.mial.training.quoter.Quoter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ShakespearQuoter implements Quoter {

    @Value("${shakespear}")
    private String message;

    @InjectRandomInt(min = 3, max = 6)
    private int repeat;

    @RunThisMethod
    public void init() {
        System.out.println("1");
        System.out.println("2");
        System.out.println("3");
        System.out.println("4");
    }

    @Override
    public void sayQuote() {
        for (int i = 0; i < repeat; i++) {
            System.out.println(message);
        }
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void destroyMethodName() {
        System.out.println("-------------- destroyMethodName ------------------");
    }
}

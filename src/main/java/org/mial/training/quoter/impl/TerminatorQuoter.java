package org.mial.training.quoter.impl;

import org.mial.training.annotation.Benchmark;
import org.mial.training.annotation.DeprecatedClass;
import org.mial.training.quoter.Quoter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@Benchmark
@DeprecatedClass(newImpl = T1000.class)
public class TerminatorQuoter implements Quoter {

    private List<String> messages;

    @Override
    public void sayQuote() {
        for (String message : messages) {
            System.out.println(message);
        }
    }

    @Value("${terminator}")
    public void setMessages(String[] messages) {
        this.messages = Arrays.asList(messages);
    }
}

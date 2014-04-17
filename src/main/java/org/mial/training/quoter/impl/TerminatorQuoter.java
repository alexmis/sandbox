package org.mial.training.quoter.impl;

import org.mial.training.annotation.Benchmark;
import org.mial.training.quoter.Quoter;

import java.util.List;

@Benchmark
public class TerminatorQuoter implements Quoter{
    private List<String> messages;

    @Override
    public void sayQuote() {
        for (String message : messages) {
            System.out.println(message);
        }
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }
}

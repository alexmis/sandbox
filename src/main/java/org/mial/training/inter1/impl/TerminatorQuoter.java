package org.mial.training.inter1.impl;

import org.mial.training.inter1.Quoter;

import java.util.List;

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

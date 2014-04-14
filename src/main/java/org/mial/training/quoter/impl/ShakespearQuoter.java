package org.mial.training.quoter.impl;

import org.mial.training.quoter.Quoter;

public class ShakespearQuoter implements Quoter {

    private String message;

    @Override
    public void sayQuote() {
        System.out.println(message);
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

package org.mial.training.inter1.impl;

import org.mial.training.inter1.Quoter;

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

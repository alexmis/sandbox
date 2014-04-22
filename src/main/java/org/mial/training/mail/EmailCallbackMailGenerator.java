package org.mial.training.mail;

import org.springframework.stereotype.Component;

@Component("2")
public class EmailCallbackMailGenerator implements MailGenerator {
    @Override
    public String generateHTML() {
        return "Don't call us we call you";
    }
}

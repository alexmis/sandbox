package org.mial.training.mail;

import org.springframework.stereotype.Component;

@Component("1")
public class WelcomeMailGenerator implements MailGenerator {
    @Override
    public String generateHTML() {
        return "WELCOME NEW CLIENT";
    }
}

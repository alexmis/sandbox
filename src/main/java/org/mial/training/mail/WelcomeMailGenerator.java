package org.mial.training.mail;

import org.springframework.stereotype.Component;

@MailTemplate(MailTemplateEnum.WELCOME)
public class WelcomeMailGenerator implements MailGenerator {
    @Override
    public String generateHTML() {
        return "WELCOME NEW CLIENT";
    }
}

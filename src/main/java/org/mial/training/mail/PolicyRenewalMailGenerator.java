package org.mial.training.mail;

import org.springframework.stereotype.Component;

@Component("3")
public class PolicyRenewalMailGenerator implements MailGenerator {
    @Override
    public String generateHTML() {
        return "Need update insurance policy";
    }
}

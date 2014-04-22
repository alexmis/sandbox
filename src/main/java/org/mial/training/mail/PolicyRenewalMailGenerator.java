package org.mial.training.mail;

import org.springframework.stereotype.Component;

@MailTemplate(MailTemplateEnum.POLICY_RENEWAL)
public class PolicyRenewalMailGenerator implements MailGenerator {
    @Override
    public String generateHTML() {
        return "Need update insurance policy";
    }
}

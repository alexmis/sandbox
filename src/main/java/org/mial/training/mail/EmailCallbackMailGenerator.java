package org.mial.training.mail;

@MailTemplate(MailTemplateEnum.EMAIL_CALLBACK)
public class EmailCallbackMailGenerator implements MailGenerator {
    @Override
    public String generateHTML() {
        return "Don't call us we call you";
    }
}

package org.mial.training.mail;

import org.springframework.stereotype.Component;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface MailTemplate {
    MailTemplateEnum value();
}

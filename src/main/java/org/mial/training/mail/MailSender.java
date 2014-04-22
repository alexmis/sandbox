package org.mial.training.mail;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;

@Component
public class MailSender {

    @InjectTemplates
    private Map<MailTemplateEnum, MailGenerator> template;

    @PostConstruct
    public void sendMail() {
        int templateCode = DBUtils.findMailTemplateCode();
        String html = template.get(MailTemplateEnum.getMailTemplateEnumByCode(templateCode)).generateHTML();
        sendMail(html);
    }

    private void sendMail(String html) {
        System.out.println("Sending mail... " + html);
    }
}

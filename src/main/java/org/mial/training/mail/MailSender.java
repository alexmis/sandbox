package org.mial.training.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;

@Component
public class MailSender {

    @Autowired
    private Map<String, MailGenerator> template;

    @PostConstruct
    public void sendMail() {
        String templateCode = String.valueOf(DBUtils.findMailTemplateCode());
        String html = template.get(templateCode).generateHTML();
        sendMail(html);
    }

    private void sendMail(String html) {
        System.out.println("Sending mail... " + html);
    }

    private String generateEmailCallbackTemplate() {
        //40 lines of business code
        return "<html>thank you for appling us, we'll call you back soon</html>";
    }

    private String generatePolicyRenewal() {
        //40 lines of business code
        return "<html>you have 7 days to renew your policy</html>";
    }

    private String generateWelcomeTemplate() {
        //40 lines of business code
        return "<html>welcome new client</html>";
    }
}


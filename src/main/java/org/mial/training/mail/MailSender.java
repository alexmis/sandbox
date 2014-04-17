package org.mial.training.mail;

public class MailSender {
    public void sendMail() {
        int mailTemplateCode = DBUtils.findMailTemplateCode();
        String html = null;
        switch (mailTemplateCode) {
            case 1:
                html = generateWelcomeTemplate();


                break;
            case 2:
                html = generatePolicyRenewal();


                break;
            case 3:
                html = generateEmailCallbackTemplate();


                break;
        }
        sendMail(html);
    }

    private void sendMail(String html) {
        System.out.println("sending mail... "+html);
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


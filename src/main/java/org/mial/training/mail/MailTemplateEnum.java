package org.mial.training.mail;

public enum MailTemplateEnum {
    WELCOME(1),
    EMAIL_CALLBACK(2),
    POLICY_RENEWAL(3);

    private int templateCode;

    MailTemplateEnum(int templateCode) {
        this.templateCode = templateCode;
    }

    public int getTemplateCode() {
        return templateCode;
    }

    public static MailTemplateEnum getMailTemplateEnumByCode(int templateCode) {
        for (MailTemplateEnum mailTemplateEnum : values()) {
            if (templateCode == mailTemplateEnum.getTemplateCode()) {
                return mailTemplateEnum;
            }
        }
        throw new IllegalArgumentException("Not found template by code: " + templateCode);
    }
}

package com.authentification.login.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MailStructure {

private String subject;
private String message;

    public MailStructure(String mailSubject, String mailMessage) {
        this.message=mailMessage;
        this.subject=mailSubject;
    }
}


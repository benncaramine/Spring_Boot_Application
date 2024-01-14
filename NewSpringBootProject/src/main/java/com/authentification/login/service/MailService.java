package com.authentification.login.service;

import com.authentification.login.DTO.MailStructure;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailService {
    @Autowired
    private JavaMailSender javaMailSender;




    private String fromMail="benncaramine@gmail.com";
    public void sendMail(String mail, MailStructure mailStructure){
        SimpleMailMessage simpleMailMessage =  new SimpleMailMessage();
        simpleMailMessage.setFrom(fromMail);
        simpleMailMessage.setSubject(mailStructure.getSubject());
        simpleMailMessage.setText(mailStructure.getMessage());
        simpleMailMessage.setTo(mail);

        javaMailSender.send(simpleMailMessage);
    }

    public void sendPdfMail(String toEmail, byte[] pdfBytes) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(fromMail);
            helper.setTo(toEmail);
            helper.setSubject("Carte d'abonnement"); // Replace with your subject
            helper.setText("Ci-joint votre carte d'abonnement: "); // Replace with your email body

            // Add the PDF as an attachment
            helper.addAttachment("document.pdf", new ByteArrayResource(pdfBytes));

            // Send the email
            javaMailSender.send(message);

            System.out.println("Email sent successfully!");
        } catch (MessagingException e) {
            System.out.println("Error sending email: " + e.getMessage());
        }
    }
}

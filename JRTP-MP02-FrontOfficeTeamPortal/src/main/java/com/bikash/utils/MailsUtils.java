//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.bikash.utils;

import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class MailsUtils {
    @Autowired
    private JavaMailSender sender;
    @Value("${spring.mail.username}")
    private String fromMail;

    public MailsUtils() {
    }

    public boolean sendMail(String to, String data, String subject) {
        try {
            MimeMessage message = this.sender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setSentDate(new Date());
            helper.setTo(to);
            helper.setFrom(new InternetAddress(this.fromMail, "Crazy Coding"));
            helper.setSubject(subject);
            helper.setText(data, true);
            this.sender.send(message);
            return true;
        } catch (Exception var6) {
            var6.printStackTrace();
            return false;
        }
    }
}

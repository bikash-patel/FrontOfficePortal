package com.bikash.utils;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.bikash.appconst.AppConst;

import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Component
public class MailsUtils {
	
	@Autowired
	private JavaMailSender sender;
	
	@Value("${spring.mail.username}")
	private String fromMail;
	
	public boolean sendMail(String to,String data,String subject)
	{
		try {
			MimeMessage message=sender.createMimeMessage();
			MimeMessageHelper helper=new MimeMessageHelper(message,true);
			helper.setSentDate(new Date());
			helper.setTo(to);
			helper.setFrom(new InternetAddress(fromMail,AppConst.STR_MAIL_BUSS_NAME));
			helper.setSubject(subject);
			helper.setText(data,true);
			sender.send(message);
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}

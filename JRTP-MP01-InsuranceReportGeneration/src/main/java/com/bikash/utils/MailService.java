package com.bikash.utils;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Component
public class MailService {
	
	@Autowired
	private JavaMailSender sender;
	
	@Value("${spring.mail.username}")
	private String fromMail;
	
	@Value("${spring.mail.tomail}")
	private String toMail;
	
	@Value("${spring.mail.text}")
	private String textMessage;
	
	public String sendMail(String requestFrom)
	{	
		try{
			//Create empty message
			MimeMessage message=sender.createMimeMessage();
			//Support mutli mime message (attachment)
			MimeMessageHelper helper=new MimeMessageHelper(message,true);
			helper.setFrom(new InternetAddress(fromMail,"Insurance Report"));
			helper.addTo(toMail);
			helper.setSubject("Citizen Insurance Report Details");
			helper.setSentDate(new Date());
			helper.setText(textMessage);
			if(requestFrom.equals("pdf"))
				helper.addAttachment("InsuranceData.pdf",new FileSystemResource("C:\\Users\\bikash patel\\Desktop\\InsuranceData.pdf"));
			else
				helper.addAttachment("InsuranceData.csv",new FileSystemResource("C:\\Users\\bikash patel\\Desktop\\InsuranceData.csv"));
			sender.send(message);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "Report sent to your mail..";
	}
}

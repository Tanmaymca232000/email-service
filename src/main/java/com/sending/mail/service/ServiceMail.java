package com.sending.mail.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sending.mail.model.Entity;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
@Service
public class ServiceMail {
	
	@Autowired
	private  JavaMailSender javaMailSender;
	public  void  sendMail(Entity entity,MultipartFile file) throws MessagingException,IOException
	{
		try {
			MimeMessage message=javaMailSender.createMimeMessage();
			MimeMessageHelper helper=new MimeMessageHelper(message,true,"UTF-8");
			  
			String htmlContent=new String(Files.readAllBytes(Paths.get(new ClassPathResource("templates/NewFile.html").getURI())));
			helper.setFrom("23tanmay1@gmail.com");
			helper.setTo(entity.getTo());
			helper.setSubject(entity.getSubject());
			helper.setText(entity.getMessage(),htmlContent);
             	//helper.setImage(entity)
			 if (file != null && !file.isEmpty()) {
	                helper.addAttachment(file.getOriginalFilename(), file);
			 }
	                javaMailSender.send(message);      
				
			}
			  
			
		catch (Exception e) {
		e.printStackTrace(); 
   		}
	}

}

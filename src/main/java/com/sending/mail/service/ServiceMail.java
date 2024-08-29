package com.sending.mail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sending.mail.model.Entity;

import jakarta.mail.internet.MimeMessage;
@Service
public class ServiceMail {
	
	@Autowired
	private  JavaMailSender javaMailSender;
	public  void  sendMail(Entity entity,MultipartFile file)
	{
		try {
			MimeMessage message=javaMailSender.createMimeMessage();
			MimeMessageHelper helper=new MimeMessageHelper(message,true);
			  
			helper.setFrom("23tanmay1@gmail.com");
			helper.setTo(entity.getTo());
			helper.setSubject(entity.getSubject());
			helper.setText(entity.getMessage());
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

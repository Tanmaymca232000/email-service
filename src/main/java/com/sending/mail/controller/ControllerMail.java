package com.sending.mail.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sending.mail.model.Entity;
import com.sending.mail.service.ServiceMail;

import jakarta.servlet.http.HttpSession;

@RestController
public class ControllerMail {
    @Autowired
	private ServiceMail serviceMail;
	@GetMapping("/a")
	public String index()
	{
	return "index";	
	}
	@PostMapping("/sendMail")
	public String sendMail(@ModelAttribute Entity entity,@RequestParam("file") MultipartFile file,HttpSession session)
	{
		try {
		MultipartFile imageFile=entity.getImage();
		serviceMail.sendMail(entity,file);
		session.setAttribute("message", "email sucessfully");
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.setAttribute("message","Failed to send email"+e.getMessage());
		}
      
	 return "redirect";	
	}
}

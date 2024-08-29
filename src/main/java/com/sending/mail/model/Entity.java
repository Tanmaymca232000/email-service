package com.sending.mail.model;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Entity {
	private String to;
	private String subject;
	private String message;
	private MultipartFile image;
	
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "Entity [to=" + to + ", subject=" + subject + ", message=" + message + ", image=" + image + "]";
	}
	public Entity(String to, String subject, String message, MultipartFile image) {
		super();
		this.to = to;
		this.subject = subject;
		this.message = message;
		this.image = image;
	}
	public Entity() {
		// TODO Auto-generated constructor stub
	}
	
	}

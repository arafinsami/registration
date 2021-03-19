package com.registration.mail;

import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import com.registration.entity.ConformationToken;
import com.registration.entity.AppUser;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MailConfig {

	private final Environment env;

	public SimpleMailMessage mail(AppUser user, ConformationToken token) {

		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(user.getEmail());
		mailMessage.setSubject("Complete Registration!");
		mailMessage.setFrom(env.getProperty("shopnobaazmailsender@gmail.com"));
		mailMessage.setText("To confirm your account, please click here : "
				+ "http://localhost:8080/confirm-account?token=" + token.getToken());
		return mailMessage;
	}

}

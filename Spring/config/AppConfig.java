package com.metacube.training.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.metacube.training.shape.MailSender;
import com.metacube.training.shape.MockMailSender;
import com.metacube.training.shape.SMTPMailSender;

//Uncomment the @Configuration while using the @Component annotation.

@Configuration
public class AppConfig {

	@Bean("mockmail")
	public MailSender mockMailSender() {
		return new MockMailSender();
	}

	@Bean("smtpmail")
	public MailSender SMTPMailSender() {
		return new SMTPMailSender();
	}
}

package com.basic;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@SpringBootApplication
public class BasicSellApp implements WebMvcConfigurer{
	
	private final LocaleChangeInterceptor localChangeInterceptor;
	
	public BasicSellApp(LocaleChangeInterceptor localChangeInterceptor) {
		this.localChangeInterceptor = localChangeInterceptor;
	}
	
	public void addInterceptors(InterceptorRegistry interceptorRegistry) {
		interceptorRegistry.addInterceptor(localChangeInterceptor);
	}
	
	public static void main(String[] args) {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("lang/message");
		messageSource.setDefaultEncoding("UTF-8");
		System.out.println(messageSource.getMessage("hello", null,Locale.ITALIAN));
		SpringApplication.run(BasicSellApp.class, args);
	}
}

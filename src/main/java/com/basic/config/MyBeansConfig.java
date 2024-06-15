package com.basic.config;

import java.util.Locale;
import java.util.TimeZone;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Configuration
public class MyBeansConfig {
	@Bean
	public LocaleResolver localeResolver() {
		CookieLocaleResolver localeResolver = new CookieLocaleResolver();
		Locale vn = new Locale("vi_VN");
		localeResolver.setDefaultLocale(vn);
		//localeResolver.setDefaultLocale(Locale.ENGLISH);
		localeResolver.setDefaultTimeZone(TimeZone.getTimeZone("UTC"));
		return localeResolver;
	}
	@Bean
	public LocaleChangeInterceptor localChangeInterceptor() {
		LocaleChangeInterceptor localChangeInterceptor = new LocaleChangeInterceptor();
		localChangeInterceptor.setParamName("localData");
		return localChangeInterceptor;
		
	}

}

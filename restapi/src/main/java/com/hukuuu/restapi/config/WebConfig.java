/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hukuuu.restapi.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * 
 * @author User
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.hukuuu.restapi" })
public class WebConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations(
				"/resources");
	}

	@Bean
	ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Override
	public void configureContentNegotiation(
			ContentNegotiationConfigurer configurer) {
		configurer.defaultContentType(MediaType.APPLICATION_JSON);
		configurer.ignoreAcceptHeader(true);
	}

	// @Bean
	// public static PropertySourcesPlaceholderConfigurer properties() {
	// PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer
	// = new PropertySourcesPlaceholderConfigurer();
	// propertySourcesPlaceholderConfigurer.setLocations(new Resource[] {
	// new ClassPathResource("persistence.properties")
	// });
	// return propertySourcesPlaceholderConfigurer;
	// }

	@Bean
	public static PropertyPlaceholderConfigurer properties() {
		PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
		Resource[] resources = new ClassPathResource[] { new ClassPathResource(
				"persistence.properties") };
		ppc.setLocations(resources);
		ppc.setIgnoreUnresolvablePlaceholders(true);
		return ppc;
	}

}
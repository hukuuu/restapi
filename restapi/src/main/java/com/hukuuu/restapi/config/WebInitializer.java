/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hukuuu.restapi.config;

import javax.servlet.Filter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.hukuuu.restapi.filter.CorsFilter;

/**
 * 
 * @author User
 */
public class WebInitializer extends
		AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { SecurityConfig.class };
//		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { WebConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	protected Filter[] getServletFilters() {
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");

		CorsFilter corsFilter = new CorsFilter();

		return new Filter[] { characterEncodingFilter, corsFilter };
	}

}

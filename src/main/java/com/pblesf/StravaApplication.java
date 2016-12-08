package com.pblesf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@SpringBootApplication
public class StravaApplication
{

	public static void main(String[] args)
	{
		SpringApplication.run(StravaApplication.class, args);
	}

	@Bean
	public ServletRegistrationBean foo() {
		DispatcherServlet dispatcherServlet = new DispatcherServlet();
		AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
		dispatcherServlet.setApplicationContext(applicationContext);
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(dispatcherServlet, "/stravaInnovation/*");

		return servletRegistrationBean;
	}
}

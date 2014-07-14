package com.sunfan.config.spring;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;


public class WebInit implements WebApplicationInitializer {	
	@Override
	public void onStartup(ServletContext sc) throws ServletException {
		// Create the 'root' Spring application context
		AnnotationConfigWebApplicationContext application = new AnnotationConfigWebApplicationContext();
		application.scan("com.sunfan.*");
		// Manages the lifecycle of the root application context
		sc.addListener(new ContextLoaderListener(application));
		AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
		webContext.setConfigLocation("com.sunfan.*");
		ServletRegistration.Dynamic appServlet = sc.addServlet("appServlet", new DispatcherServlet(webContext));
		appServlet.setLoadOnStartup(1);
		appServlet.addMapping("/");
	}
}
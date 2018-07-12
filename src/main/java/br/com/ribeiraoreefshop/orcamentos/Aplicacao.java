/**
 * 
 */
package br.com.ribeiraoreefshop.orcamentos;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * @author Tiago Ferezin Data: 12/07/2018
 */
public class Aplicacao implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {

		String localConfig = "br.com.ribeiraoreefshop.orcamentos.config";
		AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
		webApplicationContext.setConfigLocation(localConfig);

		Dynamic appServlet = servletContext.addServlet("appServlet",
				new DispatcherServlet(webApplicationContext));
		appServlet.setLoadOnStartup(1);
		appServlet.addMapping("/app/*");

		servletContext.addListener(new ContextLoaderListener(
				webApplicationContext));
	}

	// private AnnotationConfigWebApplicationContext buildApplicationContext() {
	//
	// String localConfig = "br.com.ribeiraoreefshop.orcamentos.config";
	// AnnotationConfigWebApplicationContext webApplicationContext = new
	// AnnotationConfigWebApplicationContext();
	// webApplicationContext.setConfigLocation(localConfig);
	// return webApplicationContext;
	//
	// }

}

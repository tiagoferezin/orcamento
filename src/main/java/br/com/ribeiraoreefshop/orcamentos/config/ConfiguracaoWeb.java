/**
 * 
 */
package br.com.ribeiraoreefshop.orcamentos.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author Tiago Ferezin Data: 12/07/2018
 */
@EnableWebMvc
@Configuration
@ComponentScan(basePackages="br.com.ribeiraoreefshop.orcamentos")
public class ConfiguracaoWeb extends WebMvcConfigurerAdapter {

	
	
}

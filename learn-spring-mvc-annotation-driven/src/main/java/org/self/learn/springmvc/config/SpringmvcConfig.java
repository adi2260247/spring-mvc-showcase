package org.self.learn.springmvc.config;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Extending WebMvcConfigurerAdapter is not a
 * mandate, is definitely a good practice though.
 */
@Configuration
@ComponentScan(basePackages="org.self.learn")
@EnableWebMvc
@Scope(scopeName=ConfigurableBeanFactory.SCOPE_SINGLETON)
public class SpringmvcConfig extends WebMvcConfigurerAdapter {

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/springmvc/jsp/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
}

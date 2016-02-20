package org.self.learn.springmvc;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class HelloMessageService implements ApplicationContextAware {
	private ApplicationContext context;
	
	public String getMessage(){
		return "Hello Spring!";
	}
	
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.context = applicationContext;
	}
	public ApplicationContext getContext() {
		return context;
	}
}

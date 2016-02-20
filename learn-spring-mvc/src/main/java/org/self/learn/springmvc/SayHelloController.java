package org.self.learn.springmvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class SayHelloController extends AbstractController {
	
	private HelloMessageService helloMessageService; 
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return new ModelAndView("index","message",helloMessageService.getMessage());
	}
	

	public HelloMessageService getHelloMessageService() {
		return helloMessageService;
	}

	public void setHelloMessageService(HelloMessageService helloMessageService) {
		this.helloMessageService = helloMessageService;
	}
	
}

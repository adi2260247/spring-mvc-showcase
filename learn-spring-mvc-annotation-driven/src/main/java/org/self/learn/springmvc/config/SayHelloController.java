package org.self.learn.springmvc.config;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@Scope(scopeName=WebApplicationContext.SCOPE_REQUEST)
@Scope(scopeName=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SayHelloController {
	
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public ModelAndView sayHello(){
		return new ModelAndView("index","message","Hello Spring Annotation!");
	}
}

If you wish servlet context to extend from the root context, here is what the web.xml cnofiguration will look like:
Note: Make note that init param "contextConfigLocation" for the servlet is left empty. That's how you tell Dispatcher servlet
to rather root context than initialize its own context.
http://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html

<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://java.sun.com/xml/ns/javaee"
  xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd"
  id="WebApp_ID" version="3.0">
	
	<display-name>learn-spring-mvc-annotation-driven</display-name>
	
	<servlet>
		<servlet-name>spring-dispatcher</servlet-name>
		<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
		<init-param>
			<param-name>contextClass</param-name>
			<param-value>org.springframework.web.context.support.AnnotationConfigWebApplicationContext</param-value>
		</init-param>
		<init-param>
			<param-name>contextConfigLocation</param-name>
			<param-value></param-value>
		</init-param>
		<load-on-startup>1</load-on-startup>
	</servlet>
	<servlet-mapping>
		<servlet-name>spring-dispatcher</servlet-name>
		<url-pattern>/</url-pattern>
	</servlet-mapping>
	
	<context-param>
		<description>Spring application context configuration file location</description>
		<param-name>contextClass</param-name>
		<param-value>org.springframework.web.context.support.AnnotationConfigWebApplicationContext</param-value>
	</context-param>
	<context-param>	
		<param-name>contextConfigLocation</param-name>
		<param-value>org.self.learn.springmvc.config.SpringmvcConfig</param-value>
	</context-param>
	
	<listener>
		<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
	</listener>
</web-app>
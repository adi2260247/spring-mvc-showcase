This is an alternative implementation approach to the "learn-spring-mvc" application
where all spring configuration are being driven by Java Configuration files. Refer
org.self.learn.springmvc.config.SpringmvcConfig for the View Resolver configuration.
Here is how web.xml can be written using code-based approach:

In the example above, WEB-INF/web.xml was successfully replaced with code in the form of a WebApplicationInitializer, but
the actual dispatcher-config.xml Spring configuration remained XML-based. WebApplicationInitializer is a perfect fit for
use with Spring's code-based @Configuration classes. See @Configuration Javadoc for complete details, but the following example
demonstrates refactoring to use Spring's AnnotationConfigWebApplicationContext in lieu of XmlWebApplicationContext, and
user-defined @Configuration classes AppConfig and DispatcherConfig instead of Spring XML files. This example also goes a
bit beyond those above to demonstrate typical configuration of the 'root' application context and registration of the ContextLoaderListener:

 public class MyWebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext container) {
      // Create the 'root' Spring application context
      AnnotationConfigWebApplicationContext rootContext =
        new AnnotationConfigWebApplicationContext();
      rootContext.register(AppConfig.class);

      // Manage the lifecycle of the root application context
      container.addListener(new ContextLoaderListener(rootContext));

      // Create the dispatcher servlet's Spring application context
      AnnotationConfigWebApplicationContext dispatcherContext =
        new AnnotationConfigWebApplicationContext();
      dispatcherContext.register(DispatcherConfig.class);

      // Register and map the dispatcher servlet
      ServletRegistration.Dynamic dispatcher =
        container.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
      dispatcher.setLoadOnStartup(1);
      dispatcher.addMapping("/");
    }

 }
Remember that WebApplicationInitializer implementations are detected automatically -- so you are free to package them within your application as you see fit.
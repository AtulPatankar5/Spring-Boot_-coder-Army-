package org.maverick;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;
import org.maverick.config.WebConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.io.File;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws LifecycleException {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        tomcat.getConnector();
        Connector connector = tomcat.getConnector();
        String contextPath = "";
        String baseDoc = new File("src/main/webapp").getAbsolutePath();
        Context context = tomcat.addWebapp(contextPath, baseDoc);

        AnnotationConfigWebApplicationContext appcontext = new AnnotationConfigWebApplicationContext();
        appcontext.register(WebConfig.class);

        DispatcherServlet dispatcherServlet = new DispatcherServlet(appcontext);

        Tomcat.addServlet(context, "dispatcherServlet", dispatcherServlet);

        context.addServletMapping("/", "dispatcherServlet");

        tomcat.start();

        System.out.println("Tomcat started on port 8080");

        tomcat.getServer().await();

    }
}

package com.action.http;



import java.util.EnumSet;

import javax.servlet.DispatcherType;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.FilterMapping;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.servlets.CrossOriginFilter;

import com.action.config.Config;


public class HTTPStartServer {

	public static void StartJettyServer(int port) throws Exception {

		
		ServletContextHandler handleHttpRequest = new ServletContextHandler(ServletContextHandler.SESSIONS);
		handleHttpRequest.setContextPath("/");		
		
		Server server = new Server(port); 
		
		FilterHolder filter = new FilterHolder();
		filter.setInitParameter("allowedOrigins", Config.getOrigionUri());
		//filter.setInitParameter("allowedOrigins", "http://10.200.208.96:6305");
		filter.setInitParameter("allowedMethods", "POST,GET,OPTIONS,PUT,DELETE,HEAD");
		filter.setInitParameter("allowedHeaders", "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
		CrossOriginFilter corsFilter = new CrossOriginFilter();
		filter.setFilter(corsFilter);
		
		// Use defalut value for Fillter Mapping/enumSet..
		EnumSet<DispatcherType> enumSet = EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD);
		handleHttpRequest.addFilter(filter, "/*", enumSet);
		
		server.setHandler(handleHttpRequest);
		 
		   ServletHolder jerseyServlet = handleHttpRequest.addServlet(org.glassfish.jersey.servlet.ServletContainer.class,
		           "/*");
		   jerseyServlet.setInitOrder(0);
		 
		   // Tells the Jersey Servlet which REST service/class to load.
		   jerseyServlet.setInitParameter("jersey.config.server.provider.classnames",HTTPRestServlet.class.getCanonicalName());
		 
		   server.start();
		  // server.join();

	}

}
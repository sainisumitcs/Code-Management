
package com.nuance.jettyDemo.action.HTTP;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class HTTPStartServer {

	public static void StartJettyServer(int port) throws Exception {

		Server server = new Server(port);

		ServletContextHandler handleHttpRequest = new ServletContextHandler(server, "/");

		handleHttpRequest.addServlet(HandleHttpRequest.class, "/MSE");
		handleHttpRequest.addServlet(HandleRequest.class, "/ABC");

		server.start();

	}

}
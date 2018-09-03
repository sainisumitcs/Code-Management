package com.action.http;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Path("/GetUserCircle")
public class HTTPRestServlet {

	private static Logger logger = LogManager.getLogger(HTTPRestServlet.class);

	@POST
	@Path("getInfo")
	@Produces(MediaType.APPLICATION_JSON)
	public String Get(String request) {
		logger.info("service_dnd GET Request receive  {}", request);
		Service object = new Service();
		String jsonRes = object.getService(request);
		logger.info("service_dnd GET response  {}", jsonRes);
		return jsonRes;
	}

}

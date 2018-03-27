package com.piyush.test;
import java.util.HashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
@Path("/putrequest")
public class PutExample {
	//@Produces({MediaType.TEXT_PLAIN})
	public static HashMap<String, String> hm =  new HashMap<String, String>();
	@Path("/PUT")
	@PUT
	@Produces({MediaType.TEXT_PLAIN})
	//@Produces("text/html")
	public Response getPlainText(@QueryParam("name")String name,@QueryParam("id")String id) {
		String output = "";
		if(hm.get(id)==null)
		{
			hm.put(id, name);
			output="Memory Updated with id "+id+"";
		}
		else
		{
			output="ID "+id+" already Present in Memory";
		}
		
		return Response.status(200).entity(output).build();
	}

}

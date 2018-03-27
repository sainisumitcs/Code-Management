package com.piyush.test;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
@Path("/post")
public class PostExample {
	@Path("/both")
    @POST
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Produces({MediaType.TEXT_PLAIN})
    public Response getBothResponse()
    {
        
		String str ="RECORDE CREATED SEUCCESSFULLY";
        return Response.status(200).entity(str).build();
    }

}

package com.piyush.test;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/produce")

public class ProducesExample {

	@Path("text")
	@GET
	//@Produces({MediaType.TEXT_PLAIN})
	public Response getPlainText() {

		String output = "Getting plain text now";
		return Response.status(200).entity(output).build();
	}

	@Path("xml")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Response getXMLResponse()
	{
		Student s = new Student();
		s.setAge(10);
		s.setName("JavaInterviewPoint");

		return Response.status(200).entity(s).build();
	}
	
	@Path("json")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getJSONResponse()
	{
		Student s = new Student();
		s.setAge(11);
		s.setName("JavaInterviewPoint");
		return Response.status(200).entity(s).build();
	}
	
	@Path("both")
    @GET
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Response getBothResponse()
    {
        Student s = new Student();
        s.setAge(10);
        s.setName("JavaInterviewPoint");
        
        return Response.status(200).entity(s).build();
    }
}
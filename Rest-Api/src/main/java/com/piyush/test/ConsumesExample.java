package com.piyush.test;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("consume")
public class ConsumesExample 
{
    @Path("xml")
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public String consumeXMLRequest(Student s)
    {
        System.out.println("**Received XML request**");
        System.out.println(" Name : "+s.getName());
        System.out.println(" Age  : "+s.getAge());
        return "Done";
    }
    
    @Path("json")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String consumeJSONRequest(Student s)
    {
       System.out.println("**Received JSON request**");
       System.out.println(" Name : "+s.getName());
       System.out.println(" Age  : "+s.getAge());
       return "Done";
    }
    
    @Path("{name}/{age}")
    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    public Response pathParamExample(@PathParam("name")String name,@PathParam("age") int age) {
    	String output = "name - "+name+", Age is - "+age+"";
        return Response.status(200).entity(output).build();
    }
    
    
}
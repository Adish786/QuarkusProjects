package org.code;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("customer")
public class CustomerRescource {

   public static List<String>  list = new ArrayList<String>();
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response findAll(){
return Response.ok(list).build();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/size")
    public Integer countCustomer(){
        return list.size();
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    public Response addCustomer(String newCustomer){
         list.add(newCustomer);
        return Response.ok(list).build();
    }

    @PUT
    @Path("customerUpdate")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    public Response updateCustomer( @PathParam("customerUpdate") String customerUpdate,   String updateCustomer){
       list= list.stream().map(customer->{
           if(list.equals(customerUpdate))
           {
               return updateCustomer;
           }
           return customer;
        }).collect(Collectors.toList());
       return Response.ok(list).build();
    }

    @DELETE
    @Path("{customerDelete}")
    @Consumes(MediaType.TEXT_PLAIN)
    public Response deleteCustomer(@PathParam("customerDelete") String customerDelete){
        boolean removed = list.remove(customerDelete);
        return removed ? Response.noContent().build():
                Response.status(Response.Status.BAD_REQUEST).build();
    }

}

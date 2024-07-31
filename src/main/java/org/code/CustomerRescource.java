package org.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

	public static List<Customer> list = new ArrayList<>();

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response findAll() {
		return Response.ok(list).build();
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/size")
	public Integer countCustomer() {
		return list.size();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addCustomer(Customer newCustomer) {
		list.add(newCustomer);
		return Response.ok(list).build();
	}

	@PUT
	@Path("{id}/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateMovie(@PathParam("id") Long id, @PathParam("name") String name) {
		list = list.stream().map(customer -> {
			if (customer.getId().equals(id)) {
				customer.setName(name);
			}
			return customer;
		}).collect(Collectors.toList());
		return Response.ok(list).build();
	}

	@DELETE
	@Path("customerUpdate")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateCustomer(@PathParam("id") String id) {
		Optional<Customer> customerDeleted = list.stream().filter(cust -> cust.getId().equals(id)).findFirst();
		boolean removed = false;
		if (customerDeleted.isPresent()) {
			removed = list.remove(customerDeleted.get());
		}
		if (removed) {
			return Response.noContent().build();
		}
		return Response.status(Response.Status.BAD_REQUEST).build();
	}

}

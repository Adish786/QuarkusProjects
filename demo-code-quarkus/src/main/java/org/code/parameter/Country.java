package org.code.parameter;

import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
@Path("country")
public class Country {
	@GET
	public String getCountryByName(@QueryParam("state")@DefaultValue("MH") String name) {
		return "Getting State" +name;
		
	}

}

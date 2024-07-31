package org.code.parameter.matrix;

import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.MatrixParam;
import jakarta.ws.rs.Path;

@Path("hotal")
public class Hotal {

	@GET
	public String getHotalInfo(@MatrixParam("rating") @DefaultValue("0") String rating,@MatrixParam("location") @DefaultValue("Near Matro Station") String location ,@MatrixParam("price") @DefaultValue("0.0") Double price) {
		return "Rating+" +rating + "Location= " +location + "Price=" +price ;
	}
}

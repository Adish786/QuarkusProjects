package org.restclient.service;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.restclient.entity.TvSeries;

@Path("/singlesearch/")
@Produces(MediaType.APPLICATION_JSON)
//@RegisterRestClient(baseUri = "http://api.tvmaze.com/")
@RegisterRestClient
public interface TvSeriesProxy {

    @GET
    @Path("/shows")
   TvSeries get(@QueryParam("g") String title);

}

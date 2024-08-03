package org.restclient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.restclient.entity.Episode;
import org.restclient.entity.TvSeries;
import org.restclient.service.EpisodeProxy;
import org.restclient.service.TvSeriesProxy;

import java.util.ArrayList;
import java.util.List;

@Path("/tvseries")
public class TvSeriesResource {

    @RestClient
    TvSeriesProxy proxy;
    @RestClient
    EpisodeProxy espisodeProxy;
    private List<TvSeries>  tvSeries = new ArrayList<>();


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@QueryParam("title") String title){
        TvSeries gameOfThrones = proxy.get(title);
         List<Episode> episodes=    espisodeProxy.get(gameOfThrones.getId());
       // tvSeries.add(gameOfThrones);
        return Response.ok(episodes).build();
    }

}

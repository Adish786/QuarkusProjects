package org.acme.resource;

import io.quarkus.cache.CacheInvalidate;
import io.quarkus.cache.CacheInvalidateAll;
import io.quarkus.cache.CacheResult;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class PersonResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @CacheResult(cacheName = "hello")
    public String hello() {
        System.out.println("called");
        return "Hello from Quarkus REST";
    }

    @DELETE
    @CacheInvalidate(cacheName ="hello")
    public void invalidCache(){
    }
    @POST
    @CacheInvalidateAll(cacheName = "expensiveResourceCache")
    public void invalidateAll() {

    }




}

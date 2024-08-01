package com.cdi.controller;

import com.cdi.services.NumberGenerator;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("books")
public class BookResource {
    //@Inject (part of CDI) and same as  @Autowired (part of DI)
    @Inject
    NumberGenerator numberGenerator;

    @GET
    public String getBOOKISBN() {
        return numberGenerator.generateISBNGenerator();
    }
}

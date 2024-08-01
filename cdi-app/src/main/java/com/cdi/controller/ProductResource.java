package com.cdi.controller;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import java.util.List;

import com.cdi.services.ProductService;

@Path("products")
public class ProductResource {

    @Inject
    ProductService productService;

    @GET
    public Uni<List<String>> findAll() {
        return productService.findAll();
    }
}

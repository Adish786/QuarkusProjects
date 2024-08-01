package com.cdi.controller;

import com.cdi.services.HaiService;
import com.cdi.services.HelloService;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("welcome")
public class WelcomeResource {

    @Inject
    HaiService haiService;
    @Inject
    HelloService helloService;

    @GET
    public String welcome(){
        return helloService.sayHello() + " " + haiService.sayHai();
    }
}

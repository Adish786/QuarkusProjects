package com.cdi.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import java.util.List;

import com.cdi.services.UserService;

@Path("users")
public class UserResource {
    //  UserService userService = new UserService();  // constructer injection
    @Inject
    UserService userService;   // field based injection

//    private UserService userService;

//    @Inject
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }


//    @Inject
//    public UserResource(UserService userService) {
//        this.userService = userService;
//    }

    @GET
    public List<String> users() {
        return userService.users();
    }
}

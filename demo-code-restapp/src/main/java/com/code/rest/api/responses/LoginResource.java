package com.code.rest.api.responses;

import com.code.rest.api.payload.entity.User;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("login")
public class LoginResource {

    //login
    @POST
    public Response login(User user) {
        if (user.getUserName().equals("admin") && user.getPassword().equals("admin")) {
            String jwtToken = "bsddffvc232aw32xcd3asfafd";
            return Response.status(200).entity("Login success").header("auth-token", jwtToken).build();
        }
        return Response.status(400).entity("Login Failed").build();
    }
}

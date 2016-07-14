package com.thoughtworks.order.web;

import com.thoughtworks.order.domain.User;
import com.thoughtworks.order.infrastructure.repositories.UserRepository;
import com.thoughtworks.order.web.jersey.Routes;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;

@Path("users")
public class UsersApi {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUser(Map<String, Object> userInfo,
                               @Context UserRepository userRepository,
                               @Context Routes routes) {
        String name = userInfo.get("name").toString();
        if(!name.matches("^[A-Za-z0-9]+$")) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        userRepository.save(new User(name));
        return Response.created(routes.userUrl()).build();
    }
}

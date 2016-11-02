package com.kainos.training.login.service.resource;

import com.kainos.training.login.service.model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashSet;
import java.util.Set;

@Path("/login")
@Produces(MediaType.APPLICATION_JSON)
public class LoginResource {

    private static Set<User> users;


    private final String requiredUsername;
    private final String requiredPassword;

    public LoginResource(String requiredUsername, String requiredPassword) {
        this.requiredUsername = requiredUsername;
        this.requiredPassword = requiredPassword;
        users = new HashSet<>();
    }

    @POST
    public Response login(@FormParam("username") String username,
                          @FormParam("password") final String password) {
        Response response = null;
        if (username != null && password != null) {
            User user = new User(username, password);
            if (username.toLowerCase().equals(requiredUsername.toLowerCase()) && password.equals(requiredPassword)) {
                return Response.status(Response.Status.OK).entity("Success!").build();
            }
            for (User tempUser : users) {
                if (tempUser.equals(user)) {
                    return Response.status(Response.Status.OK).entity("Success!").build();
                }
            }
        }
        return Response.status(Response.Status.UNAUTHORIZED)
                .entity("Incorrect username or password")
                .build();
    }

    @GET
    @Path("/user")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listUser() {
        return Response.status(Response.Status.OK).entity(users).build();
    }

    @POST
    @Path("/adduser")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addUser(@FormParam("username") String username,
                            @FormParam("password") String password) {
        try {
            User user = new User(username, password);
            addUser(user);
        } catch (IllegalArgumentException illegalArg) {
            return Response.status(Response.Status.NOT_ACCEPTABLE).entity(illegalArg.getMessage()).build();
        }
        return Response
                .status(Response.Status.SEE_OTHER)
                .entity("Success!")
                .build();
    }

    public void addUser(User user) throws IllegalArgumentException {
        if (!users.contains(user)) {
            users.add(user);
        } else {
            throw new IllegalArgumentException("Already contains this username");
        }
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public static Set<User> getUsers() {
        return users;
    }

    public static Set<String> usersString() {
        Set<String> strings = new HashSet<>();
        for (User user : users) {
            strings.add(user.getUserName() + "," + user.getPassword());
        }
        return strings;
    }



}

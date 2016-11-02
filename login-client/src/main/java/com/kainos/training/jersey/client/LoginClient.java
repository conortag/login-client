package com.kainos.training.jersey.client;

import com.kainos.training.jersey.client.models.User;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class LoginClient {
    private static final String BASE_URL = "http://localhost:8080";
    private static final String PATH = "login";
    private final String USERNAME_FORM_PARAM = "username";
    private final String PASSWORD_FORM_PARAM = "password";
    private final String REQUEST_ENCODING = "application/x-www-form-urlencoded";

    private final int SUCCESS_RESPONSE = 200;

    private WebTarget target;
    private WebTarget loginTarget;

    public LoginClient() {
        Client client = ClientBuilder.newClient();
        target = client.target(BASE_URL);
        loginTarget = target.path(PATH);
    }

    public boolean getLogin(String username, String password) {
        Form form = new Form();
        form.param(USERNAME_FORM_PARAM, username);
        form.param(PASSWORD_FORM_PARAM, password);

        Invocation.Builder invocationBuilder = loginTarget.request();
        Response response = invocationBuilder.post(Entity.entity(form, REQUEST_ENCODING));

        if (response.getStatus() == SUCCESS_RESPONSE) {
            return true;
        }
        return false;
    }

    public String listUser(){
        WebTarget listTarget = loginTarget.path("user");
        Invocation.Builder invocationBuilder = listTarget.request(MediaType.APPLICATION_JSON);
        //return invocationBuilder.get().readEntity(new GenericType<Set<User>>(){});
        return invocationBuilder.get().readEntity(String.class);
    }

    public boolean addUser(String username, String password){
        WebTarget addTarget = loginTarget.path("adduser");
        Form form = new Form();
        form.param(USERNAME_FORM_PARAM, username);
        form.param(PASSWORD_FORM_PARAM, password);

        Invocation.Builder invocationBuilder = addTarget.request();
        Response response = invocationBuilder.post(Entity.entity(form, REQUEST_ENCODING));

        if (response.getStatus() == Response.Status.SEE_OTHER.getStatusCode()) {
            return true;
        }
        return false;
    }


}

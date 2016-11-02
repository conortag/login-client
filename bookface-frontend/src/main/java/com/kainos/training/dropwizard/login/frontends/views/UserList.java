package com.kainos.training.dropwizard.login.frontends.views;

import com.kainos.training.dropwizard.login.frontends.models.User;
import io.dropwizard.views.View;

import java.util.Set;

/**
 * Created by conort on 26/10/2016.
 */
public class UserList extends View {

    private String users;

    public UserList(String users){
        super("/user.ftl");
        this.users = users;
    }

    public String getUsers() {
        return users;
    }
}

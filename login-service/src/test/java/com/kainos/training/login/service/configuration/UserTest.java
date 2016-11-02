package com.kainos.training.login.service.configuration;

import com.kainos.training.login.service.model.User;
import com.kainos.training.login.service.resource.LoginResource;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.core.Response;
import java.util.Set;

/**
 * Created by conort on 25/10/2016.
 */
public class UserTest {

    LoginResource resource;
    User user;

    @Before
    public void setup() {
        resource = new LoginResource("admin", "password");
        user = new User();
        user.setUserName("Conor");
        user.setPassword("test");
    }

    @Test
    public void addUser_ValidUserDetails_Pass() throws Exception {
        resource.addUser(user);
        Assert.assertTrue(resource.getUsers().contains(user));

    }

    @Test(expected = IllegalArgumentException.class)
    public void addUser_AddSameUserDetails_Fail() {
        resource.addUser(user);
        resource.addUser(user);
    }

    @Test
    public void addUser_login_success() {
        resource.addUser(user);
        Assert.assertEquals(Response.Status.OK.getStatusCode(),
                resource.login(user.getUserName(), user.getPassword()).getStatus());
    }

    @Test
    public void equals_SameObject_Pass() {
        Assert.assertTrue(user.equals(user));
    }

    @Test
    public void listUser_success() {
        resource.addUser(user);
        for(User tempUser : (Set<User>) resource.listUser().getEntity()){
            Assert.assertEquals(user.getUserName()+","+user.getPassword(),tempUser.toString());
        }
    }
}
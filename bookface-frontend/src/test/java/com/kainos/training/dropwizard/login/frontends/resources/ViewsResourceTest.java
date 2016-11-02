package com.kainos.training.dropwizard.login.frontends.resources;

import com.kainos.login.models.Book;
import com.kainos.training.dropwizard.login.frontends.views.Index;
import com.kainos.training.dropwizard.login.frontends.views.LoginFailureView;
import com.kainos.training.dropwizard.login.frontends.views.LoginSuccessView;
import com.kainos.training.dropwizard.login.frontends.views.UserList;
import com.kainos.training.jersey.client.BookClient;
import com.kainos.training.jersey.client.LoginClient;
import io.dropwizard.views.View;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ViewsResourceTest {

    private ViewsResource resource;
    private LoginClient client;
    private BookClient bookClient;


    @Before
    public void setup(){
        client = mock(LoginClient.class);
        bookClient = mock(BookClient.class);
        resource = new ViewsResource(client, bookClient);
    }

    @Test
    public void login_AnyValue_ReturnsView(){
        Assert.assertEquals(true, resource.login() instanceof View);
    }

    @Test
    public void login_InvalidDetails_ReturnsFailureView(){
        when(client.getLogin("adminuser","password12")).thenReturn(false);
        Assert.assertTrue(resource.loginDetails("adminuser","password12") instanceof LoginFailureView);
    }

    @Test
    public void login_ValidDetails_ReturnTrue(){
        when(client.getLogin("admin","password")).thenReturn(true);
        Assert.assertTrue(resource.loginDetails("admin","password") instanceof LoginSuccessView);
    }

    @Test
    public void addUser_AnyValue_ReturnsView(){
        Assert.assertEquals(true, resource.addUser() instanceof View);
    }

    @Test
    public void completeUser_ValidDetails_ReturnTrue(){
        when(client.addUser("conor","taggart")).thenReturn(true);
        Assert.assertTrue(resource.addComplete("conor","taggart") instanceof Index);
    }

    @Test
    public void listUser_ValidDetails_ReturnTrue(){
        when(client.addUser("conor","taggart")).thenReturn(true);
        Assert.assertTrue(resource.listUsers() instanceof UserList);
    }

    @Test
    public void getAllBooks_ReturnView(){
        Assert.assertEquals(true, resource.getAllBooks() instanceof View);
    }
}

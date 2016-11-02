package com.kainos.training.dropwizard.login.frontends.resources;

import com.kainos.login.models.Book;
import com.kainos.training.dropwizard.login.frontends.views.*;
import com.kainos.training.jersey.client.BookClient;
import com.kainos.training.jersey.client.LoginClient;
import io.dropwizard.views.View;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;

@Path("/test")
public class ViewsResource {

    private LoginClient client;
    private BookClient bookClient;


    public ViewsResource(LoginClient client, BookClient bookClient) {
        this.client = client;
        this.bookClient = bookClient;
    }

    @GET
    @Timed
    @Path("/login")
    @Produces(MediaType.TEXT_HTML)
    public View login() {
        return new Index();
    }

    @POST
    @Timed
    @Path("login-details")
    @Produces(MediaType.TEXT_HTML)
    public View loginDetails(@FormParam("username") String username,
                             @FormParam("password") String password) {
        if (client.getLogin(username, password)) {
            return new LoginSuccessView();
        }
        return new LoginFailureView();
    }

    @GET
    @Timed
    @Path("adduser")
    @Produces(MediaType.TEXT_HTML)
    public View addUser() {
        return new AddUser();
    }

    @POST
    @Timed
    @Path("complete-add")
    @Produces(MediaType.TEXT_HTML)
    public View addComplete(@FormParam("username") String username,
                             @FormParam("password") String password) {
        if (client.addUser(username, password)) {
            return new Index();
        }
        return new LoginFailureView();
    }

    @GET
    @Timed
    @Path("user")
    @Produces(MediaType.TEXT_HTML)
    public View listUsers(){
        System.out.println(client.listUser());
        return new UserList(client.listUser());
    }

    @GET
    @Timed
    @Path("book")
    @Produces(MediaType.TEXT_HTML)
    public View getAllBooks(){
        for(Book book : bookClient.getAllBooks()){
            System.out.println("Getting ID");
            System.out.println(book.getId());
        }
        return new Booklist(bookClient.getAllBooks());
    }

    @GET
    @Timed
    @Path("book/{index}")
    @Produces(MediaType.TEXT_HTML)
    public View getBook(@PathParam("index") int index){
        return new BookView(bookClient.getBook(index));
    }

}

package com.kainos.training.jersey.client;

import com.kainos.login.models.Book;

import javax.jws.WebResult;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by conort on 01/11/2016.
 */
public class BookClient {

    private static final String BASE_URL = "http://localhost:8080";
    private static final String PATH = "books";
    //private final String REQUEST_ENCODING = "application/x-www-form-urlencoded";

    private WebTarget target;
    private WebTarget allBooksTarget;

    public BookClient() {
        Client client = ClientBuilder.newClient();
        target = client.target(BASE_URL);
        target = target.path(PATH);
        allBooksTarget = target.path("book");
    }

    public List<Book> getAllBooks() {
        Invocation.Builder invocationBuilder = allBooksTarget.request();
        Response response = invocationBuilder.get();
        if (response.getStatus() == 200) {
            return response.readEntity(new GenericType<ArrayList<Book>>() {
            });
        }
        return null;
        //return invocationBuilder.get().readEntity(String.class);
    }

    public Book getBook(int index) {
        //WebTarget bookTarget = allBooksTarget.queryParam("index", index);
        WebTarget bookTarget = allBooksTarget.path(String.valueOf(index));
        Invocation.Builder invocationBuilder = bookTarget.request();
        Response response = invocationBuilder.get();
        if (response.getStatus() == 200) {
            return response.readEntity(Book.class);
        }
        return null;
    }

}

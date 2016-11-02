package com.kainos.training.login.service.resource;

import com.kainos.login.models.Book;
import com.kainos.login.models.Genre;
import org.joda.time.DateTime;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {

    public static List<Book> bookList;

    public BookResource() {
        bookList = new ArrayList<>();
        Book book = new Book();
        book.setAuthor("Terry Pratchett");
        book.setGenre(Genre.FANTASY);
        book.setId(1);
        book.setPublishDate(DateTime.now());
        book.setTitle("Thief of Time");
        bookList.add(book);
    }

    @GET
    @Path("/book")
    public Response getAllBooks(){
        return  Response.status(Response.Status.OK).entity(bookList).build();
    }

    @GET
    @Path("/book/{index}")
    public Response getBook(@PathParam("index")int index){
        Book book = bookList.get(index - 1);
        return Response.status(Response.Status.OK).entity(book).build();
    }

}

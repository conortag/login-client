package com.kainos.training.login.service.resource;

import com.kainos.login.models.Book;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by conort on 01/11/2016.
 */
public class BookResourceTest {

    private BookResource resource;

    @Before
    public void setup(){
        resource = new BookResource();
    }

    @Test
    public void getAllBooks() throws Exception {
        List<Book> booklist = (ArrayList<Book>) resource.getAllBooks().getEntity();
        for (Book book: booklist) {
            System.out.println(book.getId());
        }
    }

    @Test
    public void getBook(){
        Book book = (Book) resource.getBook(1).getEntity();
        System.out.println(book.getId());
    }

}
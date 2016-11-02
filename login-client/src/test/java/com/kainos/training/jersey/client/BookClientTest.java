package com.kainos.training.jersey.client;

import com.kainos.login.models.Book;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by conort on 01/11/2016.
 */
public class BookClientTest {

    private BookClient bookClient;

    @Before
    public void setup(){
        bookClient = new BookClient();
    }

    @Test
    public void getAllBooks() throws Exception {
        for(Book book : bookClient.getAllBooks()){
            System.out.println(book.getId());
        }
    }

    @Test
    public void getBook(){
        Book book = bookClient.getBook(1);
        System.out.println(book.getId());
    }

}
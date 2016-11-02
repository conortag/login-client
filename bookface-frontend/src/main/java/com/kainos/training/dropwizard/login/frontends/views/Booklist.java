package com.kainos.training.dropwizard.login.frontends.views;

import com.kainos.login.models.Book;
import io.dropwizard.views.View;

import java.util.List;

/**
 * Created by conort on 01/11/2016.
 */
public class Booklist extends View {

    private List<Book> booklist;

    public Booklist(List<Book> booklist){
        super("/booklist.ftl");
        this.booklist = booklist;
    }

    public List<Book> getBooklist() {
        return booklist;
    }
}

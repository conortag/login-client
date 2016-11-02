package com.kainos.training.dropwizard.login.frontends.views;

import com.kainos.login.models.Book;
import io.dropwizard.views.View;

import java.nio.charset.Charset;

/**
 * Created by conort on 01/11/2016.
 */
public class BookView extends View {

    public static final String name = "/bookview.ftl";

    private Book book;

    public BookView(Book book) {
        super(name);
        this.book = book;
    }

    public BookView(Charset charset, Book book) {
        super(name, charset);
        this.book = book;
    }

    public Book getBook(){
        return this.book;
    }
}

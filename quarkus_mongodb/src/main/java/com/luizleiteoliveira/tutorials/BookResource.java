package com.luizleiteoliveira.tutorials;

import com.luizleiteoliveira.tutorials.domain.Book;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/books")
public class BookResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy";
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Book createBookWithParameters(Book bookReceived) {
        Book book = Book.findByName(bookReceived.name);

        if ( book != null) {
            book.author = bookReceived.author;
            book.name = bookReceived.name;
            book.yearPublication = bookReceived.yearPublication;
            book.update();
        } else {
            book = new Book();
            book.author = bookReceived.author;
            book.name = bookReceived.name;
            book.yearPublication = bookReceived.yearPublication;
            book.persist();
        }
        return book;
    }

    @GET
    @Path("/findAll")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> listAllBooks() {
        List<Book> allBooks = Book.listAll();
        return allBooks;
    }

    @DELETE
    @Path("/deleteAll")
    public void deleteAll() {
        Book.deleteAll();
    }
}
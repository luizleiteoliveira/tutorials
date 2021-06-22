package com.luizleiteoliveira.tutorials;

import com.luizleiteoliveira.tutorials.domain.Book;
import com.luizleiteoliveira.tutorials.service.BookService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Consumes(MediaType.APPLICATION_JSON)
@Path("/books")
public class BookResource {

    @Inject
    BookService bookService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy";
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Book createBookWithParameters(Book bookReceived) {
        return bookService.createOrUpdateBook(bookReceived);
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
package com.luizleiteoliveira.tutorials;

import com.luizleiteoliveira.tutorials.domain.Book;
import com.luizleiteoliveira.tutorials.service.BookService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/books")
public class BookResource {

    @Inject
    BookService bookService;

    @GET
    public Book findBookByName(String name) {
        return bookService.findBookByName(name);
    }

    @POST
    public Book createBookWithParameters(Book bookReceived) {
        return bookService.createOrUpdateBook(bookReceived);
    }

    @GET
    @Path("/findAll")
    public List<Book> listAllBooks() {
        return bookService.findAllBooks();
    }

    @DELETE
    @Path("/deleteAll")
    public void deleteAll() {
        bookService.deleteAllBooks();
    }
}
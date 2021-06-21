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
    public Book createBookWithParameters(@QueryParam("name") String name, @QueryParam("author") String author, @QueryParam("year") Integer year) {
        Book book = Book.findByName(name);

        if ( book != null) {
            book.author = author;
            book.name = name;
            book.yearPublication = year;
            book.update();
        } else {
            book = new Book();
            book.author = author;
            book.name = name;
            book.yearPublication = year;
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
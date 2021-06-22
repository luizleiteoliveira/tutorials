package com.luizleiteoliveira.tutorials.service;

import com.luizleiteoliveira.tutorials.domain.Book;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BookService {


    public Book createOrUpdateBook(Book bookReceived) {
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
}

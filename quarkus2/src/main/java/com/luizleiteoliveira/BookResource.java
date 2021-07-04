package com.luizleiteoliveira;

import com.luizleiteoliveira.dto.Book;
import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;

import java.util.Arrays;
import java.util.List;

@GraphQLApi
public class BookResource {

    @Query("allBooks")
    @Description("This  query will return all books that we have")
    public List<Book> findAllBooks() {
        Book book = new Book();
        book.setAuthor("Luiz Leite");
        book.setName("A vida de Luiz");
        Book book1 = new Book();
        book1.setName("O blog de Luiz");
        book1.setAuthor("Luiz Leite");
        return Arrays.asList(book, book1);
    }

}

package com.harbour.springboot;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookController {
    @QueryMapping
    public Book bookById(@Argument String id) {
        return Book.getById(id);
    }

    @MutationMapping
    public Book createBook(@Argument String id, @Argument String name, @Argument int pageCount, @Argument String authorId) {
        Book book = new Book(id, name, pageCount, authorId);
        Book.addBook(book);
        return book;
    }

    @QueryMapping
    public List<Book> books() {
        return Book.allBooks();
    }

    @SchemaMapping
    public Author author(Book book) {
        return Author.getById(book.authorId());
    }
}
package com.harbour.springboot;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

import static com.harbour.springboot.BookMapper.toVm;

@Controller
public class BookController {
    private final AuthorRepository2 authorRepository;
    private final BookRepository bookRepository;

    public BookController(AuthorRepository2 authorRepository, BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @QueryMapping
    public Book bookById(@Argument String id) {
        return bookRepository.getById(id);
    }

    @MutationMapping
    public BookVM createBook(@Argument String id, @Argument String name, @Argument int pageCount, @Argument String authorId) {
        Book book = new Book(id, name, pageCount, authorId, 10);
        bookRepository.addBook(book);
        return toVm(book);
    }

    @QueryMapping
    public List<Book> books() {
        return bookRepository.allBooks();
    }

    @SchemaMapping
    public Author author(Book book) {
        return authorRepository.getById(book.authorId());
    }
}
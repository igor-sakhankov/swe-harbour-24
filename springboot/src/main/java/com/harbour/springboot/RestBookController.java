package com.harbour.springboot;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.harbour.springboot.BookMapper.toVm;

@RestController
public class RestBookController {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public RestBookController(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @GetMapping("/restbooks")
    public List<BookVM> restAllBooks() {
        return bookRepository.allBooks().stream().map(BookMapper::toVm).toList();
    }
}
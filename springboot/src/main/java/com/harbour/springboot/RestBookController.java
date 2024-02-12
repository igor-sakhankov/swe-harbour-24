package com.harbour.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestBookController {
    private final AuthorRepository2 authorRepository;
    private final BookRepository bookRepository;

    public RestBookController(AuthorRepository2 authorRepository, BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @GetMapping("/restbooks")
    public List<BookVM> restAllBooks() {
        return bookRepository.allBooks().stream().map(BookMapper::toVm).toList();
    }
}
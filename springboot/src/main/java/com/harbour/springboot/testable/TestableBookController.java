package com.harbour.springboot.testable;

import com.harbour.springboot.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestableBookController {

    private final BookService bookService;

    @PostMapping("/v1/books")
    public String createBook(@RequestBody(required = true) Book book) {
        bookService.createBook(book);
        return "success";
    }
}

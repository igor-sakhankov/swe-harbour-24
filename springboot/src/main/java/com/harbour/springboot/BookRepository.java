package com.harbour.springboot;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class BookRepository {
    private static List<Book> books = new ArrayList<>();
    static {
        books.add(new Book("book-1", "Effective Java", 416, "author-1", 10));
        books.add(new Book("book-2", "Hitchhiker's Guide to the Galaxy", 208, "author-2", 10));
        books.add(new Book("book-3", "Down Under", 436, "author-3", 10));
    }

    public static Book getById(String id) {
        return books.stream()
                .filter(book -> book.id().equals(id))
                .findFirst()
                .orElse(null);
    }

    public static List<Book> allBooks() {
        return books;
    }

    public static void addBook(Book book) {
        books.add(book);
    }
}

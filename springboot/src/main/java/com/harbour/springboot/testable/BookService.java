package com.harbour.springboot.testable;

import com.harbour.springboot.Author;
import com.harbour.springboot.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BookService {


    public String getBookName(Book book) {
        // upadte rating of author
        return book.bookName() + " is a great book" + " and it has " + book.pageCount() + " pages";
    }

    public void  createBook(Book book) {
        System.out.println("Book created: " + book);
    }
}

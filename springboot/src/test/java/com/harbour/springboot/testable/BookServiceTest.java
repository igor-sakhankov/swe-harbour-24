package com.harbour.springboot.testable;

import com.harbour.springboot.Book;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class BookServiceTest {

    @Test
    void getBookName() {
        // Given
        Clock clock = mock(Clock.class);
        Logger mock = mock(Logger.class);
        BookService bookService = new BookService();
        Book book = mock(Book.class);
        when(book.bookName()).thenReturn("Clean Code");
        when(book.pageCount()).thenReturn(123);
        // When
        String bookName = bookService.getBookName(book);
        // Then
        assertEquals("Clean Code", bookName);
        verify(mock, only()).log(any(), anyString());
    }
}
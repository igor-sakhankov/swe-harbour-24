package com.harbour.springboot;

public class BookMapper {

    public static BookVM toVm(Book book) {
        return new BookVM(book.id(), book.bookName(), book.pageCount(), book.authorId());
    }
}

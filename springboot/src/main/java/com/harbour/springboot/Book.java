package com.harbour.springboot;

public record Book (String id, String bookName, int pageCount, String authorId, int someVerySecretInformation) {
}
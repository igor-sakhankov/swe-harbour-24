package com.harbour.springboot;

import com.harbour.springboot.testable.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RestBookControllerTest {

    @LocalServerPort
    private int port;

    @MockBean
    BookService bookService;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void whenIncorrectBodyShouldFail() {
        ResponseEntity<String> actual = this.restTemplate.postForEntity("http://localhost:" + port + "/v1/books",
                String.class, String.class);
        assertThat(actual.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    void whenCorrectBodyShouldSucceed() {
        ResponseEntity<String> actual = this.restTemplate.postForEntity("http://localhost:" + port + "/v1/books",
                new Book("book-2", "Hitchhiker's Guide to the Galaxy", 208, "author-2", 10), String.class, String.class);
        assertThat(actual.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void whenCorrectBodyShouldCallTheService() {
        // When
        ResponseEntity<String> actual = this.restTemplate.postForEntity("http://localhost:" + port + "/v1/books",
                new Book("book-2", "Hitchhiker's Guide to the Galaxy", 208, "author-2", 10), String.class, String.class);
        // Then
        verify(bookService).createBook(any());
    }
}
package com.devtiro.graphql.controllers;

import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.devtiro.graphql.domain.Book;
import com.devtiro.graphql.services.BookService;

@Controller
public class GraphQLController {

    private final BookService bookService;

    public GraphQLController(final BookService bookService) {
        this.bookService = bookService;
    }


    @QueryMapping
    public Iterable<Book> listBooks(
        @Argument("page") final Integer page,
        @Argument("size") final Integer size) {

        return bookService.getBooks(
            PageRequest.of(
                Optional.ofNullable(page).orElse(0),
                Optional.ofNullable(size).orElse(20)
            )
        );
    }

    @QueryMapping
    public Optional<Book> bookByIsbn(@Argument("isbn") final String isbn) {
        return bookService.getBook(isbn);
    }

}

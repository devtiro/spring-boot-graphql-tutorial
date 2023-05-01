package com.devtiro.graphql.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.devtiro.graphql.domain.Book;

public interface BookService {

    Page<Book> getBooks(Pageable pagable);

    Optional<Book> getBook(String isbn);

}

package com.devtiro.graphql.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devtiro.graphql.domain.Book;
import com.devtiro.graphql.repositories.BookRepository;
import com.devtiro.graphql.services.BookService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;

    public BookServiceImpl(final BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Page<Book> getBooks(final Pageable pageable) {
        log.info("Getting books...");
        return bookRepository.findAll(pageable);
    }

    @Override
    public Optional<Book> getBook(String isbn) {
        return bookRepository.findById(isbn);
    }

}

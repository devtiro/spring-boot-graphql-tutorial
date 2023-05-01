package com.devtiro.graphql.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.devtiro.graphql.domain.Book;

public interface BookRepository extends CrudRepository<Book, String>,
        PagingAndSortingRepository<Book, String> {
}

package com.themoon.bookstore.bookstoreServices;

import com.themoon.bookstore.entity.Book;

import java.util.List;

public interface BookServices {
    void save(Book tempBook) ;

    List<Book> findAll();

    Book findById(int id );

    void deleteById(int id) ;
}

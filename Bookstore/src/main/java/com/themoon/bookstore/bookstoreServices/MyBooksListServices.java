package com.themoon.bookstore.bookstoreServices;

import com.themoon.bookstore.entity.MyBooksList;

import java.util.List;

public interface MyBooksListServices {
    void saveMyBook(MyBooksList myBooksList);

    List<MyBooksList> getAllMyBooks();

    void deleteById(int id);
}

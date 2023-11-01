package com.themoon.bookstore.bookStoreRepository;

import com.themoon.bookstore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

    // that's it we don't need to write more code here
}

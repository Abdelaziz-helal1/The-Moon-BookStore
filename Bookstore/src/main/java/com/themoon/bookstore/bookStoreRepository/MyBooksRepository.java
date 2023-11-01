package com.themoon.bookstore.bookStoreRepository;

import com.themoon.bookstore.entity.MyBooksList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyBooksRepository extends JpaRepository<MyBooksList, Integer> {

    // that's it we don't need to write an implementation for it
}

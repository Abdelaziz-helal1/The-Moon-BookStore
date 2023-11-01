package com.themoon.bookstore.bookstoreServices;

import com.themoon.bookstore.bookStoreRepository.BookRepository;
import com.themoon.bookstore.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServicesImpl implements BookServices {

    private BookRepository bookRepos ;
    @Autowired
    public BookServicesImpl(BookRepository bookRepository)
    {
        this.bookRepos = bookRepository ;
    }
    @Override
    public void save(Book tempBook) {
        bookRepos.save(tempBook);
    }

    @Override
    public List<Book> findAll() {
        return bookRepos.findAll();
    }

    @Override
    public Book findById(int id) {

        return bookRepos.findById(id).get();
    }

    @Override
    public void deleteById(int id) {
        bookRepos.deleteById(id);
    }
}

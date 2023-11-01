package com.themoon.bookstore.bookstoreServices;

import com.themoon.bookstore.bookStoreRepository.MyBooksRepository;
import com.themoon.bookstore.entity.MyBooksList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBooksListServicesImpl implements MyBooksListServices {

    private MyBooksRepository myBooksRepository ;

    @Autowired
    public MyBooksListServicesImpl(MyBooksRepository myBooksRepository) {
        this.myBooksRepository = myBooksRepository;
    }

    @Override
    public void saveMyBook(MyBooksList myBooksList) {
        myBooksRepository.save(myBooksList);
    }

    @Override
    public List<MyBooksList> getAllMyBooks() {
        return myBooksRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        myBooksRepository.deleteById(id);
    }
}

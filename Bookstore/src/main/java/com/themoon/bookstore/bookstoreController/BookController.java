package com.themoon.bookstore.bookstoreController;

import com.themoon.bookstore.bookstoreServices.BookServices;
import com.themoon.bookstore.bookstoreServices.BookServicesImpl;
import com.themoon.bookstore.bookstoreServices.MyBooksListServices;
import com.themoon.bookstore.entity.Book;
import com.themoon.bookstore.entity.MyBooksList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController {

    private BookServices services ;
    private MyBooksListServices myBooksListServices ;

    @Autowired
    public BookController(BookServices bookServices , MyBooksListServices myBooksListServices)
    {
        super();
        this.services = bookServices ;
        this.myBooksListServices = myBooksListServices ;
    }

    @GetMapping("/")
    public String home()
    {
        return "home" ;
    }

    @GetMapping("/book_register")
    public String bookRegister()
    {
        return "book-register";
    }

    @GetMapping("/available_books")
    public ModelAndView getAllBooks()
    {
        List<Book> list = services.findAll() ;
        return new ModelAndView("available-books","book",list);
    }

    @PostMapping("/save")
    public String addBook(@ModelAttribute Book tempBook)
    {
        services.save(tempBook);
        return "redirect:/available_books";
    }

    @GetMapping("/my_books")
    public String getMyBooks(Model model)
    {
        List<MyBooksList> tempList = myBooksListServices.getAllMyBooks();
        model.addAttribute("book",tempList);
        return "myBooks" ;
    }

    @RequestMapping("/myList/{id}")
    public String getMyList(@PathVariable("id") int id )
    {
        Book tempBook = services.findById(id) ;
        MyBooksList tempMyBooksList = new MyBooksList(tempBook.getId(),tempBook.getName(),
                tempBook.getAuthor(),tempBook.getPrice());

        myBooksListServices.saveMyBook(tempMyBooksList);
        return "redirect:/my_books";
    }

    @RequestMapping("/deleteMyList/{id}")
    public String deleteMyList(@PathVariable("id") int id)
    {
        myBooksListServices.deleteById(id);
        return "redirect:/my_books";
    }

    @RequestMapping("/editBook/{id}")
    public String editMyBooks(@PathVariable("id") int id, Model model)
    {
        Book tempBook = services.findById(id);
        model.addAttribute("book",tempBook);
        return "edit-book";
    }

    @RequestMapping("/deleteMyBook/{id}")
    public String deleteMyBook(@PathVariable("id") int id)
    {
        services.deleteById(id);
        return "redirect:/available_books";
    }
}

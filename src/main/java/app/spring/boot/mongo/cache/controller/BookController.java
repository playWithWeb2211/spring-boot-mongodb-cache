package app.spring.boot.mongo.cache.controller;

import app.spring.boot.mongo.cache.model.Book;
import app.spring.boot.mongo.cache.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class BookController {

    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookService bookService;

    @PostMapping("/book")
    public Book addBook(@RequestBody Book book){
        logger.info("Inside method addBook..");
        return bookService.addBook(book);
    }

//    @PutMapping("/book")
//    public Book updateBook(@RequestBody Book book){
//        logger.info("Inside method update Book..");
//        return bookService.updateBook(book);
//    }

    @PutMapping("/book")
    public Book updateBookWithIdAndName(@RequestParam String objectId, @RequestParam String name, @RequestBody Book book){
        return bookService.updateBookByObjectIdAndName(objectId,name,book);
    }

    @GetMapping("/book/{id}")
    public Book getBook(@PathVariable String id){
        logger.info("Inside method get Book..");
        return bookService.getBook(id);
    }

    @RequestMapping("/book/{id}")
    public Book deleteBook(@PathVariable String id){
        logger.info("Inside method delete Book..");
        return bookService.deleteBook(id);
    }


}

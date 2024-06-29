package app.spring.boot.mongo.cache.service;

import app.spring.boot.mongo.cache.model.Book;

public interface BookService {
    public Book addBook(Book book);

    public Book updateBook(Book book);

    public Book getBook(String id);

    public Book deleteBook(String id);

    public Book updateBookByObjectIdAndName(String objectId, String name, Book book);
}

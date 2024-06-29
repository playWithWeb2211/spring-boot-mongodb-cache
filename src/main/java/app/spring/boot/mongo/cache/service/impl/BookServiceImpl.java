package app.spring.boot.mongo.cache.service.impl;

import app.spring.boot.mongo.cache.model.Book;
import app.spring.boot.mongo.cache.repository.BookRepository;
import app.spring.boot.mongo.cache.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;


@Slf4j
@Service
public class BookServiceImpl implements BookService {

    private static Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);

    }

    @Override
    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book getBook(String id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isEmpty()){
            logger.error("The book with the given Id is not present");
        }else{
            return bookOptional.get();
        }
        return null;
    }

    @Override
    public Book deleteBook(String id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isEmpty()){
            logger.error("The book with the given Id is not present so not proceeding with delete");
        }else{
            bookRepository.deleteById(id);
            return bookOptional.get();
        }
        return null;
    }

    @Override
    public Book updateBookByObjectIdAndName(String objectId, String name, Book book) {
        Query query = new Query(Criteria.where("_id").is(new ObjectId(objectId)).and("name").is(name));
        Update update = new Update()
                .set("category",book.getCategory())
                .set("author", book.getAuthor())
                .set("publisher", book.getPublisher())
                .set("edition", book.getEdition());

        return mongoTemplate.findAndModify(query,update,Book.class);
    }


}

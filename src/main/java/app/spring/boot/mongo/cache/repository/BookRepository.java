package app.spring.boot.mongo.cache.repository;

import app.spring.boot.mongo.cache.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends MongoRepository<Book,String> {
    Optional<Book> findById(long id);

    void deleteById(long id);

    <S extends Book> S save(S book);
}

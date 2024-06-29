package app.spring.boot.mongo.cache.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "books")
@NoArgsConstructor
@Getter
@Setter
public class Book implements Serializable {

    private static final long serialVersionUID = 1307525040224585678L;
    @Id
    private ObjectId id;
    private String name;
    private String category;
    private String author;
    private String publisher;
    private String edition;
}

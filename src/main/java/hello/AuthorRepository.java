package hello;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorRepository extends MongoRepository<Author, String> {
    public Author findByFirstName(String firstName);
    public List<Author> findByLastName(String lastName);
}

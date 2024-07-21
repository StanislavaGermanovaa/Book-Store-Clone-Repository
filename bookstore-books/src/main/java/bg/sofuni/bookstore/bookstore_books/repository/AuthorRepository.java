package bg.sofuni.bookstore.bookstore_books.repository;


import bg.sofuni.bookstore.bookstore_books.model.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
    Author findAuthorByName(String name);
}

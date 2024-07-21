package bg.sofuni.bookstore.bookstore_books.repository;

import bg.sofuni.bookstore.bookstore_books.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
}

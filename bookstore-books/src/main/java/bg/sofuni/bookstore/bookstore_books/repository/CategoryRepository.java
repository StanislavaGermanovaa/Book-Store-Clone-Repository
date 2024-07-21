package bg.sofuni.bookstore.bookstore_books.repository;


import bg.sofuni.bookstore.bookstore_books.model.entity.Category;
import bg.sofuni.bookstore.bookstore_books.model.enums.CategoryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    Optional<Category> findByName(CategoryType name);
}

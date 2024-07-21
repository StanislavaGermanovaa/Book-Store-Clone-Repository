package bg.sofuni.bookstore.bookstore_books.model.dto;

import bg.sofuni.bookstore.bookstore_books.model.entity.Author;
import bg.sofuni.bookstore.bookstore_books.model.enums.CategoryType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class BookDTO {
    private Long id;
    private String title;

    private AuthorDTO author;

    //@NotNull
    private CategoryType category;

    private String imageURL;

    //@NotNull
    private String description;

    //@NotNull
    //@Positive
    private double price;
}

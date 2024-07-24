package bg.sofuni.bookstore.bookstore_books.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CategoryDTO {
    private Long id;
    private String name;

    private String description;
}

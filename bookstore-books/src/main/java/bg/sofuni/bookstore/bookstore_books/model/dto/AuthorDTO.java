package bg.sofuni.bookstore.bookstore_books.model.dto;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
public class AuthorDTO {
    private Long id;
    private String name;

    @JsonBackReference
    private Set<BookDTO> books;
}

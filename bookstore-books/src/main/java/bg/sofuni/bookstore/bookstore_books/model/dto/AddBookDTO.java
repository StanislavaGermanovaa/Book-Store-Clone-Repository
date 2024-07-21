package bg.sofuni.bookstore.bookstore_books.model.dto;


import bg.sofuni.bookstore.bookstore_books.model.enums.CategoryType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class AddBookDTO {

 // @NotNull
 private String title;

 private String author;

 //@NotNull
 private CategoryType category;

 private String imageURL;

 //@NotNull
 private String description;

 //@NotNull
 //@Positive
 private double price;

}
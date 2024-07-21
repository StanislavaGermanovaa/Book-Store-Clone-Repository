package bg.sofuni.bookstore.bookstore_books.web;

import bg.sofuni.bookstore.bookstore_books.model.dto.AddBookDTO;
import bg.sofuni.bookstore.bookstore_books.model.dto.BookDTO;
import bg.sofuni.bookstore.bookstore_books.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {


    private static final Logger LOGGER = LoggerFactory.getLogger(BookController.class);
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping
    public ResponseEntity<List<BookDTO>> getAllBooks(){
        return ResponseEntity.ok(
                bookService.getAllBooks());
    }

    @PostMapping
    public ResponseEntity<BookDTO> createOrder(@RequestBody AddBookDTO addBookDTO){
        LOGGER.info("Going to create an book");
        bookService.addBook(addBookDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BookDTO> deleteById(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return ResponseEntity
                .noContent()
                .build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getById(@PathVariable("id") Long id) {
        return ResponseEntity
                .ok(bookService.getBookById(id));
    }

}

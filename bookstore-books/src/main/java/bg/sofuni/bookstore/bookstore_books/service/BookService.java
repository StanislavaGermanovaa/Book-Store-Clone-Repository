package bg.sofuni.bookstore.bookstore_books.service;

import bg.sofuni.bookstore.bookstore_books.model.dto.AddBookDTO;
import bg.sofuni.bookstore.bookstore_books.model.dto.BookDTO;

import java.util.List;

public interface BookService {

    void addBook(AddBookDTO addBookDTO);
    public List<BookDTO> getAllBooks();

    void deleteBook(Long id);

    BookDTO getBookById(Long id);
}

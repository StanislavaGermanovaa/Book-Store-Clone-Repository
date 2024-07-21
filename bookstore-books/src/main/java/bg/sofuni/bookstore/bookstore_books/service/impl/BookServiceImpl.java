package bg.sofuni.bookstore.bookstore_books.service.impl;

import bg.sofuni.bookstore.bookstore_books.model.dto.AddBookDTO;
import bg.sofuni.bookstore.bookstore_books.model.dto.BookDTO;
import bg.sofuni.bookstore.bookstore_books.model.entity.Author;
import bg.sofuni.bookstore.bookstore_books.model.entity.Book;
import bg.sofuni.bookstore.bookstore_books.model.entity.Category;
import bg.sofuni.bookstore.bookstore_books.repository.AuthorRepository;
import bg.sofuni.bookstore.bookstore_books.repository.BookRepository;
import bg.sofuni.bookstore.bookstore_books.repository.CategoryRepository;
import bg.sofuni.bookstore.bookstore_books.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    private final ModelMapper modelMapper;
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;
    private final BookRepository bookRepository;

    public BookServiceImpl(ModelMapper modelMapper, AuthorRepository authorRepository, CategoryRepository categoryRepository, BookRepository bookRepository) {
        this.modelMapper = modelMapper;
        this.authorRepository = authorRepository;
        this.categoryRepository = categoryRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void addBook(AddBookDTO addBookDTO) {
        Book book = modelMapper.map(addBookDTO, Book.class);

        Author author = authorRepository.findAuthorByName(addBookDTO.getAuthor());
        if (author == null) {
            author = new Author();
            author.setName(addBookDTO.getAuthor());

            author = authorRepository.save(author);
        }

        Category category = categoryRepository.findByName(addBookDTO.getCategory())
                .orElseThrow(() -> new IllegalArgumentException("Invalid category"));

        book.setCategory(category);
        book.setAuthor(author);
        bookRepository.save(book);

    }

    @Override
    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(book -> modelMapper.map(book, BookDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public BookDTO getBookById(Long id) {
        return bookRepository
                .findById(id)
                .map(book -> modelMapper.map(book, BookDTO.class))
                .orElseThrow(()->new IllegalArgumentException("Not found!"));
    }
}

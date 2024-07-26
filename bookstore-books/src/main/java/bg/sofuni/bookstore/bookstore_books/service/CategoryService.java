package bg.sofuni.bookstore.bookstore_books.service;

import bg.sofuni.bookstore.bookstore_books.model.dto.AddCategoryDTO;
import bg.sofuni.bookstore.bookstore_books.model.dto.CategoryDTO;
import bg.sofuni.bookstore.bookstore_books.model.entity.Category;
import bg.sofuni.bookstore.bookstore_books.repository.CategoryRepository;
import org.antlr.v4.runtime.tree.pattern.ParseTreePattern;
import org.modelmapper.Converters;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public CategoryService(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    public List<CategoryDTO> getAllCategories() {

        return categoryRepository.findAll().stream()
                .map(book -> modelMapper.map(book, CategoryDTO.class))
                .collect(Collectors.toList());

    }

    public void addCategory(AddCategoryDTO addCategoryDTO) {
        Category category = modelMapper.map(addCategoryDTO, Category.class);
        categoryRepository.save(category);
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    public CategoryDTO getCategoryById(Long id) {
        return categoryRepository
                .findById(id)
                .map(book -> modelMapper.map(book, CategoryDTO.class))
                .orElseThrow(()->new IllegalArgumentException("Not found!"));
    }

    public CategoryDTO getCategoryByName(String name) {

        return categoryRepository
                .findByCategory(name)
                .map(category -> modelMapper.map(category, CategoryDTO.class))
                .orElseThrow(() -> new IllegalArgumentException("Category not found"));
    }
}

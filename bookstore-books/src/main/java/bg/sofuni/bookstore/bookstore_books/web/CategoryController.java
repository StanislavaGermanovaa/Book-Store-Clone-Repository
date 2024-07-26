package bg.sofuni.bookstore.bookstore_books.web;


import bg.sofuni.bookstore.bookstore_books.model.dto.AddCategoryDTO;

import bg.sofuni.bookstore.bookstore_books.model.dto.CategoryDTO;

import bg.sofuni.bookstore.bookstore_books.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);
    private final CategoryService categoryService;

    public CategoryController(CategoryService bookService) {
        this.categoryService = bookService;
    }


    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAllCategories(){
        return ResponseEntity.ok(
                categoryService.getAllCategories());
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody AddCategoryDTO addCategoryDTO){
        categoryService.addCategory(addCategoryDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CategoryDTO> deleteById(@PathVariable("id") Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity
                .noContent()
                .build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getById(@PathVariable("id") Long id) {
        return ResponseEntity
                .ok(categoryService.getCategoryById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<CategoryDTO> getByName(@PathVariable("name") String name) {
        return ResponseEntity
                .ok(categoryService.getCategoryByName(name));
    }


}

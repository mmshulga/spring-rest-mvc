package my.mmshulga.springrestmvc.controllers;

import my.mmshulga.api.v1.model.CategoryDTO;
import my.mmshulga.api.v1.model.CategoryDTOList;
import my.mmshulga.springrestmvc.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/categories/")
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public CategoryDTOList getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("{name}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryDTO getCategoryByName(@PathVariable String name) {
        return categoryService.findCategoryByName(name);
    }
}

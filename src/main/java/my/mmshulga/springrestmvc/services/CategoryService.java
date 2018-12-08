package my.mmshulga.springrestmvc.services;

import my.mmshulga.api.v1.model.CategoryDTO;

import java.util.List;

public interface CategoryService {
    List<CategoryDTO> getAllCategories();
    CategoryDTO findCategoryByName(String name);
}

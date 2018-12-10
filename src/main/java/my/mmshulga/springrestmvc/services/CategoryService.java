package my.mmshulga.springrestmvc.services;

import my.mmshulga.springrestmvc.api.v1.model.CategoryDTO;
import my.mmshulga.springrestmvc.api.v1.model.CategoryDTOList;

public interface CategoryService {
    CategoryDTOList getAllCategories();
    CategoryDTO findCategoryByName(String name);
}

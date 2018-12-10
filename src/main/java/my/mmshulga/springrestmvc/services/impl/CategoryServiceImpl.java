package my.mmshulga.springrestmvc.services.impl;

import my.mmshulga.springrestmvc.api.v1.mapper.CategoryMapper;
import my.mmshulga.springrestmvc.api.v1.model.CategoryDTO;
import my.mmshulga.springrestmvc.api.v1.model.CategoryDTOList;
import my.mmshulga.springrestmvc.repositories.CategoryRepository;
import my.mmshulga.springrestmvc.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper     = CategoryMapper.INSTANCE;
    }

    @Override
    public CategoryDTOList getAllCategories() {
        CategoryDTOList categoryDTOList = new CategoryDTOList();

        List<CategoryDTO> categories = categoryRepository
                .findAll()
                .stream()
                .map(categoryMapper::categoryToCategoryDTO)
                .collect(Collectors.toList());

        categoryDTOList.setCategories(categories);

        return categoryDTOList;
    }

    @Override
    public CategoryDTO findCategoryByName(String name) {
        return categoryMapper.categoryToCategoryDTO(categoryRepository.findByName(name));
    }
}

package my.mmshulga.api.v1.mapper;

import my.mmshulga.api.v1.model.CategoryDTO;
import my.mmshulga.springrestmvc.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);
    CategoryDTO categoryToCategoryDTO(Category category);
}

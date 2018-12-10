package my.mmshulga.springrestmvc.api.v1.mapper;

import javax.annotation.Generated;
import my.mmshulga.springrestmvc.api.v1.model.CategoryDTO;
import my.mmshulga.springrestmvc.model.Category;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-12-10T11:57:27+0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_144 (Oracle Corporation)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public CategoryDTO categoryToCategoryDTO(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryDTO categoryDTO = new CategoryDTO();

        categoryDTO.setId( category.getId() );
        categoryDTO.setName( category.getName() );

        return categoryDTO;
    }
}

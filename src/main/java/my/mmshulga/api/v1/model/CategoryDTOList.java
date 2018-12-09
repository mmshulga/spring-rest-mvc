package my.mmshulga.api.v1.model;

import lombok.Data;

import java.util.List;

@Data
public class CategoryDTOList {
    private List<CategoryDTO> categories;
}

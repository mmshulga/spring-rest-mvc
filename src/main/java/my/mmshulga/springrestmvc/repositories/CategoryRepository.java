package my.mmshulga.springrestmvc.repositories;

import my.mmshulga.springrestmvc.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> { }

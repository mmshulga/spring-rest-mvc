package my.mmshulga.springrestmvc.repositories;

import my.mmshulga.springrestmvc.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> { }

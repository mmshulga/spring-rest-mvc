package my.mmshulga.springrestmvc.repositories;

import my.mmshulga.springrestmvc.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> { }

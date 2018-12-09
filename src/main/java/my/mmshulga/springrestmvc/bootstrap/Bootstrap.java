package my.mmshulga.springrestmvc.bootstrap;

import my.mmshulga.springrestmvc.model.Category;
import my.mmshulga.springrestmvc.model.Customer;
import my.mmshulga.springrestmvc.repositories.CategoryRepository;
import my.mmshulga.springrestmvc.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {
    private final CategoryRepository categoryRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        initCategories();
        initCustomers();
    }

    private void initCustomers() {
        int n = 5;
        for (int i = 1; i <= n; i++) {
            Customer customer = new Customer();
            customer.setFirstName("FirstName#" + i);
            customer.setLastName("LastName#" + i);
            customerRepository.save(customer);
        }
        System.out.println("Customers loaded = " + n);
    }

    private void initCategories() {
        Category fruits = new Category();
        fruits.setName("Fruits");

        Category dried = new Category();
        dried.setName("Dried");

        Category fresh = new Category();
        fresh.setName("Fresh");

        Category exotic = new Category();
        exotic.setName("Exotic");

        Category nuts = new Category();
        nuts.setName("Nuts");

        categoryRepository.save(fruits);
        categoryRepository.save(dried);
        categoryRepository.save(fresh);
        categoryRepository.save(exotic);
        categoryRepository.save(nuts);

        System.out.println("Categories loaded = " + categoryRepository.count());
    }
}

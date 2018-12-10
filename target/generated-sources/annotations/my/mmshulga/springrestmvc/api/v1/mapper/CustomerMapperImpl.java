package my.mmshulga.springrestmvc.api.v1.mapper;

import javax.annotation.Generated;
import my.mmshulga.springrestmvc.api.v1.model.CustomerDTO;
import my.mmshulga.springrestmvc.model.Customer;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-12-10T11:57:27+0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_144 (Oracle Corporation)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerDTO customerToCustomerDTO(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDTO customerDTO = new CustomerDTO();

        customerDTO.setId( customer.getId() );
        customerDTO.setFirstName( customer.getFirstName() );
        customerDTO.setLastName( customer.getLastName() );

        return customerDTO;
    }

    @Override
    public Customer customerDTOToCustomer(CustomerDTO customer) {
        if ( customer == null ) {
            return null;
        }

        Customer customer1 = new Customer();

        customer1.setId( customer.getId() );
        customer1.setFirstName( customer.getFirstName() );
        customer1.setLastName( customer.getLastName() );

        return customer1;
    }
}

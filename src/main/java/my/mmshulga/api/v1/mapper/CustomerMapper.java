package my.mmshulga.api.v1.mapper;

import my.mmshulga.api.v1.model.CustomerDTO;
import my.mmshulga.springrestmvc.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
    CustomerDTO customerToCustomerDTO(Customer customer);
    Customer customerDTOToCustomer(CustomerDTO customer);
}

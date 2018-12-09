package my.mmshulga.springrestmvc.services;

import my.mmshulga.api.v1.model.CustomerDTO;
import my.mmshulga.api.v1.model.CustomerDTOList;

public interface CustomerService {
    CustomerDTOList getAllCustomers();
    CustomerDTO getCustomerById(Long id);
    CustomerDTO createNewCustomer(CustomerDTO customerDTO);
    CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO);
    CustomerDTO patchCustomer(Long id, CustomerDTO customerDTO);
}

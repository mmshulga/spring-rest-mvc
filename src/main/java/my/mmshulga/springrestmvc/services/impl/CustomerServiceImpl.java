package my.mmshulga.springrestmvc.services.impl;

import my.mmshulga.springrestmvc.api.v1.mapper.CustomerMapper;
import my.mmshulga.springrestmvc.api.v1.model.CustomerDTO;
import my.mmshulga.springrestmvc.api.v1.model.CustomerDTOList;
import my.mmshulga.springrestmvc.exceptions.ResourceNotFoundException;
import my.mmshulga.springrestmvc.model.Customer;
import my.mmshulga.springrestmvc.repositories.CustomerRepository;
import my.mmshulga.springrestmvc.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
        this.customerMapper     = CustomerMapper.INSTANCE;
    }

    @Override
    public CustomerDTOList getAllCustomers() {
        CustomerDTOList customerDTOList= new CustomerDTOList();

        List<CustomerDTO> customers =  customerRepository
                .findAll()
                .stream()
                .map(customerMapper::customerToCustomerDTO)
                .collect(Collectors.toList());

        customerDTOList.setCustomers(customers);
        return customerDTOList;
    }

    @Override
    public CustomerDTO getCustomerById(Long id) {
        return customerMapper
                .customerToCustomerDTO(
                        customerRepository
                        .findById(id)
                        .orElseThrow(ResourceNotFoundException::new)
                );
    }

    @Override
    public CustomerDTO createNewCustomer(CustomerDTO customerDTO) {
        return saveCustomer(customerMapper.customerDTOToCustomer(customerDTO));
    }

    @Override
    public CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO) {
        Customer customer = customerMapper.customerDTOToCustomer(customerDTO);
        customer.setId(id);
        return saveCustomer(customer);
    }

    @Override
    public CustomerDTO patchCustomer(Long id, CustomerDTO customerDTO) {
        return customerRepository.findById(id).map(customer -> {
            if (customerDTO.getFirstName() != null) {
                customer.setFirstName(customerDTO.getFirstName());
            }

            if (customerDTO.getLastName() != null) {
                customer.setLastName(customerDTO.getLastName());
            }

            return saveCustomer(customer);
        }).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public void deleteCustomerById(Long id) {
        customerRepository.deleteById(id);
    }

    private CustomerDTO saveCustomer(Customer customer) {
        return customerMapper.customerToCustomerDTO(customerRepository.save(customer));
    }
}

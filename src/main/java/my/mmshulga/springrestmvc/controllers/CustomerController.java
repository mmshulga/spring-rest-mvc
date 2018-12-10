package my.mmshulga.springrestmvc.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import my.mmshulga.springrestmvc.api.v1.model.CustomerDTO;
import my.mmshulga.springrestmvc.api.v1.model.CustomerDTOList;
import my.mmshulga.springrestmvc.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Api(description = "Customer API endpoint")
@RestController
@RequestMapping("/api/v1/customers/")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @ApiOperation(value = "Returns all customers")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTOList getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @ApiOperation(value = "Returns customer for a given id")
    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    @ApiOperation(value = "Creates customer")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDTO createNewCustomer(@RequestBody CustomerDTO customerDTO) {
        return customerService.createNewCustomer(customerDTO);
    }

    @ApiOperation(value = "Updates an existing customer")
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO updateExistingCustomer(@PathVariable Long id, @RequestBody CustomerDTO customerDTO) {
        return customerService.updateCustomer(id, customerDTO);
    }

    @ApiOperation(value = "Patches existing customer")
    @PatchMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO patchExistingCustomer(@PathVariable Long id, @RequestBody CustomerDTO customerDTO) {
        return customerService.patchCustomer(id, customerDTO);
    }

    @ApiOperation(value = "Deletes existing customer for a given id")
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomerById(id);
    }
}

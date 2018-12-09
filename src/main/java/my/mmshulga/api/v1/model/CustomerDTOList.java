package my.mmshulga.api.v1.model;

import lombok.Data;

import java.util.List;

@Data
public class CustomerDTOList {
    private List<CustomerDTO> customers;
}

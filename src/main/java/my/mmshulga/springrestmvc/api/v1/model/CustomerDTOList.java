package my.mmshulga.springrestmvc.api.v1.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class CustomerDTOList {
    @ApiModelProperty(value = "List of customers")
    private List<CustomerDTO> customers;
}

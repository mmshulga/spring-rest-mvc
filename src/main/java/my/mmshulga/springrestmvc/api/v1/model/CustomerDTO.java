package my.mmshulga.springrestmvc.api.v1.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CustomerDTO {

    @ApiModelProperty(value = "Unique identifier of a customer")
    private Long id;

    @ApiModelProperty(value = "First name of a customer")
    private String firstName;

    @ApiModelProperty(value = "Last name of a customer")
    private String lastName;
}

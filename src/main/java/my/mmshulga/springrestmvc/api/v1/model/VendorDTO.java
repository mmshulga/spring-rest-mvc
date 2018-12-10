package my.mmshulga.springrestmvc.api.v1.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class VendorDTO {

    @ApiModelProperty(value = "Unique identifier of a vendor")
    private Long id;

    @ApiModelProperty(value = "Name of a vendor")
    private String name;
}

package my.mmshulga.springrestmvc.api.v1.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class VendorDTOList {
    @ApiModelProperty(value = "List of vendors")
    private List<VendorDTO> vendors;
}

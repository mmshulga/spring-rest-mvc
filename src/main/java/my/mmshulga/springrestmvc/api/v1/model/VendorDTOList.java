package my.mmshulga.springrestmvc.api.v1.model;

import lombok.Data;

import java.util.List;

@Data
public class VendorDTOList {
    private List<VendorDTO> vendors;
}

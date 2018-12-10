package my.mmshulga.springrestmvc.api.v1.mapper;

import my.mmshulga.springrestmvc.api.v1.model.VendorDTO;
import my.mmshulga.springrestmvc.model.Vendor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VendorMapper {
    VendorMapper INSTANCE = Mappers.getMapper(VendorMapper.class);
    VendorDTO vendorToVendorDTO(Vendor vendor);
    Vendor vendorDTOToVendor(VendorDTO vendorDTO);
}

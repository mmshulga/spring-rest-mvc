package my.mmshulga.springrestmvc.api.v1.mapper;

import javax.annotation.Generated;
import my.mmshulga.springrestmvc.api.v1.model.VendorDTO;
import my.mmshulga.springrestmvc.model.Vendor;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-12-10T11:57:27+0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_144 (Oracle Corporation)"
)
@Component
public class VendorMapperImpl implements VendorMapper {

    @Override
    public VendorDTO vendorToVendorDTO(Vendor vendor) {
        if ( vendor == null ) {
            return null;
        }

        VendorDTO vendorDTO = new VendorDTO();

        vendorDTO.setId( vendor.getId() );
        vendorDTO.setName( vendor.getName() );

        return vendorDTO;
    }

    @Override
    public Vendor vendorDTOToVendor(VendorDTO vendorDTO) {
        if ( vendorDTO == null ) {
            return null;
        }

        Vendor vendor = new Vendor();

        vendor.setId( vendorDTO.getId() );
        vendor.setName( vendorDTO.getName() );

        return vendor;
    }
}

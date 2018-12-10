package my.mmshulga.springrestmvc.services;

import my.mmshulga.api.v1.model.VendorDTO;
import my.mmshulga.api.v1.model.VendorDTOList;

public interface VendorService {
    VendorDTOList getAllVendors();
    VendorDTO getVendorById(Long id);
    VendorDTO createNewVendor(VendorDTO vendorToCreate);
    VendorDTO updateVendor(Long id, VendorDTO vendorDTO);
    VendorDTO patchVendor(Long id, VendorDTO vendorDTO);
    void deleteVendorById(Long id);
}

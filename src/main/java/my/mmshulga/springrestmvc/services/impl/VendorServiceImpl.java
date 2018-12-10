package my.mmshulga.springrestmvc.services.impl;

import my.mmshulga.springrestmvc.api.v1.mapper.VendorMapper;
import my.mmshulga.springrestmvc.api.v1.model.VendorDTO;
import my.mmshulga.springrestmvc.api.v1.model.VendorDTOList;
import my.mmshulga.springrestmvc.exceptions.ResourceNotFoundException;
import my.mmshulga.springrestmvc.model.Vendor;
import my.mmshulga.springrestmvc.repositories.VendorRepository;
import my.mmshulga.springrestmvc.services.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VendorServiceImpl implements VendorService {

    private final VendorRepository vendorRepository;
    private final VendorMapper vendorMapper;

    @Autowired
    public VendorServiceImpl(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
        this.vendorMapper = VendorMapper.INSTANCE;
    }

    @Override
    public VendorDTOList getAllVendors() {
        VendorDTOList vendorDTOList = new VendorDTOList();
        List<VendorDTO> vendors = vendorRepository
                .findAll()
                .stream()
                .map(vendorMapper::vendorToVendorDTO)
                .collect(Collectors.toList());

        vendorDTOList.setVendors(vendors);

        return vendorDTOList;
    }

    @Override
    public VendorDTO getVendorById(Long id) {
        return vendorMapper
                .vendorToVendorDTO(vendorRepository
                        .findById(id)
                        .orElseThrow(ResourceNotFoundException::new));
    }

    @Override
    public VendorDTO createNewVendor(VendorDTO vendorToCreate) {
        return saveVendor(vendorMapper.vendorDTOToVendor(vendorToCreate));
    }

    @Override
    public VendorDTO updateVendor(Long id, VendorDTO vendorDTO) {
        Vendor vendor = vendorMapper.vendorDTOToVendor(vendorDTO);
        vendor.setId(id);
        return saveVendor(vendor);
    }

    @Override
    public VendorDTO patchVendor(Long id, VendorDTO vendorDTO) {
        Vendor vendor = vendorRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        if (vendorDTO.getName() != null) {
            vendor.setName(vendorDTO.getName());
        }

        return saveVendor(vendor);
    }

    @Override
    public void deleteVendorById(Long id) {
        vendorRepository.deleteById(id);
    }

    private VendorDTO saveVendor(Vendor vendor) {
        Vendor savedVendor = vendorRepository.save(vendor);
        return vendorMapper.vendorToVendorDTO(savedVendor);
    }
}

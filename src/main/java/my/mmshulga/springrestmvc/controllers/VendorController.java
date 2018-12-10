package my.mmshulga.springrestmvc.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import my.mmshulga.springrestmvc.api.v1.model.VendorDTO;
import my.mmshulga.springrestmvc.api.v1.model.VendorDTOList;
import my.mmshulga.springrestmvc.services.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Api(description = "Vendors API endpoint")
@RestController
@RequestMapping("/api/v1/vendors/")
public class VendorController {
    private final VendorService vendorService;

    @Autowired
    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @ApiOperation(value = "Returns all existing vendors")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public VendorDTOList getAllVendors() {
        return vendorService.getAllVendors();
    }

    @ApiOperation(value = "Returns vendor for a given id")
    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public VendorDTO getVendorById(@PathVariable Long id) {
        return vendorService.getVendorById(id);
    }

    @ApiOperation(value = "Creates a new vendor")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VendorDTO createNewVendor(@RequestBody VendorDTO vendorDTO) {
        return vendorService.createNewVendor(vendorDTO);
    }

    @ApiOperation(value = "Updates existing vendor")
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public VendorDTO updateVendor(@PathVariable Long id, @RequestBody VendorDTO vendorDTO) {
        return vendorService.updateVendor(id, vendorDTO);
    }

    @ApiOperation(value = "Patches existing vendor")
    @PatchMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public VendorDTO patchVendor(@PathVariable Long id, @RequestBody VendorDTO vendorDTO) {
        return vendorService.patchVendor(id, vendorDTO);
    }

    @ApiOperation(value = "Deletes vendor for a given id")
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteVendor(@PathVariable Long id) {
        vendorService.deleteVendorById(id);
    }
}

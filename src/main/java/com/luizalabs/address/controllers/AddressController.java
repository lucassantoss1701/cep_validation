package com.luizalabs.address.controllers;

import com.luizalabs.address.domain.Address;
import com.luizalabs.address.domain.dto.AddressDTO;
import com.luizalabs.address.services.interfaces.AddressServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/address")
public class AddressController {

    @Autowired
    private AddressServiceInterface addressService;

    @GetMapping(value = "/ceps")
    public ResponseEntity<AddressDTO> findAddressByCEP(@RequestBody AddressDTO addressWithCep){
        Address address = addressService.findAddressByCEP(addressWithCep.getCep());
        AddressDTO addressDTO = new AddressDTO(address);
        return ResponseEntity.ok().body(addressDTO);
    }
}

package com.luizalabs.luizalabs.controllers;

import com.luizalabs.luizalabs.domain.Address;
import com.luizalabs.luizalabs.services.interfaces.AddressServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {

    @Autowired
    private AddressServiceInterface addressService;

    @GetMapping(value = "/{cep}")
    public ResponseEntity<Address> findAddressByCEP(@RequestBody String cep){
        Address address = addressService.findAddressByCEP(cep);
        return ResponseEntity.ok().body(address);
    }
}

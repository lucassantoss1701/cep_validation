package com.luizalabs.address.controllers;

import com.luizalabs.address.domain.Address;
import com.luizalabs.address.domain.dto.AddressDTO;
import com.luizalabs.address.services.interfaces.AddressServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/address")
public class AddressController {

    @Autowired
    private AddressServiceInterface addressService;

    @GetMapping(value = "/ceps/{cepAddress}")
    public ResponseEntity<AddressDTO> findAddressByCEP(@PathVariable String cepAddress){
        Address address = addressService.findAddressByCEP(cepAddress);
        AddressDTO addressDTO = new AddressDTO(address);
        return ResponseEntity.ok().body(addressDTO);
    }


    @PostMapping
    public ResponseEntity<Void> newAdress(@RequestBody AddressDTO addressWithCep){
        Address address = addressService.insertNewAdress(addressWithCep.toEntity());
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("ceps/{cep}").buildAndExpand(address.getCep()).toUri();

        return ResponseEntity.created(uri).build();
    }
}

package com.luizalabs.luizalabs.services;


import com.luizalabs.luizalabs.domain.Address;
import com.luizalabs.luizalabs.repositories.AddressRepository;
import com.luizalabs.luizalabs.services.interfaces.AddressServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService implements AddressServiceInterface {

    @Autowired
    private AddressRepository addressRepository;

    public Address findAddressByCEP(String cep){
        Address address = addressRepository.findByCep(cep);
        return address;
    }


}

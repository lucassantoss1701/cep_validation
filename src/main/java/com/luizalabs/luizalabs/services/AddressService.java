package com.luizalabs.luizalabs.services;


import com.luizalabs.luizalabs.domain.Address;
import com.luizalabs.luizalabs.repositories.AddressRepository;
import com.luizalabs.luizalabs.services.excepetions.ObjectNotFoundException;
import com.luizalabs.luizalabs.services.interfaces.AddressServiceInterface;
import com.luizalabs.luizalabs.services.util.CEPUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService implements AddressServiceInterface {

    @Autowired
    private AddressRepository addressRepository;

    public int countCEP = 8;

    public Address findAddressByCEP(String cep){
        Optional<Address> address = addressRepository.findByCep(cep);
        if(!address.isPresent() && countCEP!= 0){
            countCEP--;
            findAddressByCEP(CEPUtil.returnCEP(cep, countCEP));
        }
        return address.orElseThrow(() -> new ObjectNotFoundException("CEP Inválido"));
    }


}

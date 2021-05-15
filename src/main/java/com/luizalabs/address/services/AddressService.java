package com.luizalabs.address.services;


import com.luizalabs.address.domain.Address;
import com.luizalabs.address.repositories.AddressRepository;
import com.luizalabs.address.services.excepetions.ObjectNotFoundException;
import com.luizalabs.address.services.interfaces.AddressServiceInterface;
import com.luizalabs.address.services.util.CEPUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService implements AddressServiceInterface {

    @Autowired
    private AddressRepository addressRepository;

    public Address findAddressByCEP(String cep){
        int indexCEP = cep.length();
        Optional<Address> address = recursiveVerifyCEP(cep, indexCEP);
        return address.orElseThrow(() -> new ObjectNotFoundException("CEP Inválido!"));
    }

    @Override
    public Address insertNewAdress(Address address) {
        address.setId(null);
        return addressRepository.save(address);
    }

    private Optional<Address> recursiveVerifyCEP(String cep, int indexCEP){
        Optional<Address> address = addressRepository.findByCep(cep);
        if(address.isEmpty() && indexCEP!= 0){
            indexCEP--;
            return recursiveVerifyCEP(CEPUtil.returnCEP(cep, indexCEP), indexCEP);
        }
        return address;
    }
}

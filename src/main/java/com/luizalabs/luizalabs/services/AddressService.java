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

    public Address findAddressByCEP(String cep){
        int indexCEP = cep.length();
        Optional<Address> address = recursiveVerifyCEP(cep, indexCEP);
        return address.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: , Tipo: " + Address.class.getName()));
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

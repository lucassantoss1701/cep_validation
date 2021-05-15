package com.luizalabs.address.services.interfaces;

import com.luizalabs.address.domain.Address;

public interface AddressServiceInterface {
    Address findAddressByCEP(String cep);

    Address insertNewAdress(Address address);
}

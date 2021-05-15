package com.luizalabs.luizalabs.services.interfaces;

import com.luizalabs.luizalabs.domain.Address;
public interface AddressServiceInterface {
    Address findAddressByCEP(String cep);
}

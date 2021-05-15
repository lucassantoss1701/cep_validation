package com.luizalabs.luizalabs.services.interfaces;

import com.luizalabs.luizalabs.domain.Address;

import java.util.Optional;

public interface AddressServiceInterface {
    Address findAddressByCEP(String cep);
}

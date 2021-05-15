package com.luizalabs.luizalabs.repositories;

import com.luizalabs.luizalabs.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    Address findByCep(String cep);
}

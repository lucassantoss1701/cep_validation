package com.luizalabs.address.repositories;

import com.luizalabs.address.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    Optional<Address> findByCep(String cep);
}

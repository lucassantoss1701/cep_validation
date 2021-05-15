package com.luizalabs.address.repositories;

import com.luizalabs.address.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Integer> {
}

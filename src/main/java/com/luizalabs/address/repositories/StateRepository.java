package com.luizalabs.address.repositories;

import com.luizalabs.address.domain.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Integer> {
}

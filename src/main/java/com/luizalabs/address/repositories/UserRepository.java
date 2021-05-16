package com.luizalabs.address.repositories;

import com.luizalabs.address.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}

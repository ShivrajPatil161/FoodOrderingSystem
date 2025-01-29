package com.webTechnology.foodOrderingSystem.Repo;

import com.webTechnology.foodOrderingSystem.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Integer> {
    Optional<User> findUserByEmail(String email);
}


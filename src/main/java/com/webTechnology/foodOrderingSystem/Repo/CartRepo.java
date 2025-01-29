package com.webTechnology.foodOrderingSystem.Repo;

import com.webTechnology.foodOrderingSystem.Model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepo extends JpaRepository<Cart, Long> {
}
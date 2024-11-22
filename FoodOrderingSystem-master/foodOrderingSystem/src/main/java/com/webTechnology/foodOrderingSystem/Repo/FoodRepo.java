package com.webTechnology.foodOrderingSystem.Repo;

import com.webTechnology.foodOrderingSystem.Model.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepo extends JpaRepository<FoodItem, Long> {
}
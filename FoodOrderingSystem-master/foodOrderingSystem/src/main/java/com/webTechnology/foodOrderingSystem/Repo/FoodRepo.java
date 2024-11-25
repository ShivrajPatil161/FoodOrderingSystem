package com.webTechnology.foodOrderingSystem.Repo;

import com.webTechnology.foodOrderingSystem.Model.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodRepo extends JpaRepository<FoodItem, Long> {
    List<FoodItem> findAllByCategory_Id(int id);
}
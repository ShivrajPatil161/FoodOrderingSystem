package com.webTechnology.foodOrderingSystem.Repo;

import com.webTechnology.foodOrderingSystem.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
}

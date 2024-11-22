package com.webTechnology.foodOrderingSystem.Service;

import com.webTechnology.foodOrderingSystem.Model.FoodItem;
import com.webTechnology.foodOrderingSystem.Repo.FoodRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodService {
    @Autowired
    private FoodRepo foodRepository;

    public FoodItem saveFood(FoodItem foodItem) {
        return foodRepository.save(foodItem);
    }

    public List<FoodItem> getAllFoodItems() {
        return foodRepository.findAll();
    }

    public Optional<FoodItem> getFoodById(Long id) {
        return foodRepository.findById(id);
    }

    public void deleteFood(Long id) {
        foodRepository.deleteById(id);
    }

}

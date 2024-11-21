package com.webTechnology.foodOrderingSystem.Service;

import com.webTechnology.foodOrderingSystem.Model.FoodItem;
import com.webTechnology.foodOrderingSystem.Repo.FoodRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {
    @Autowired
    private FoodRepo foodRepository;

    public List<FoodItem> getAllFoodItems() {
        return foodRepository.findAll();
    }
}

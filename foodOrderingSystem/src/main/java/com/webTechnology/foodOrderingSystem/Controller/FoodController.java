package com.webTechnology.foodOrderingSystem.Controller;

import com.webTechnology.foodOrderingSystem.Model.FoodItem;
import com.webTechnology.foodOrderingSystem.Service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/food")
public class FoodController {
    @Autowired
    private FoodService foodService;

    // Display All FoodItems
    @GetMapping
    public String getAllFoodItems(Model model) {
        model.addAttribute("foodItems", foodService.getAllFoodItems());
        return "food/index"; // Create this template in `templates/food/index.html`
    }

    // Show Form to Add/Edit FoodItem
    @GetMapping("/form")
    public String showForm(@RequestParam(required = false) Long id, Model model) {
        if (id != null) {
            foodService.getFoodById(id).ifPresent(food -> model.addAttribute("food", food));
        } else {
            model.addAttribute("food", new FoodItem());
        }
        return "food/form"; // Create this template in `templates/food/form.html`
    }

    // Save FoodItem
    @PostMapping
    public String saveFood(@ModelAttribute FoodItem foodItem) {
        foodService.saveFood(foodItem);
        return "redirect:/food";
    }

    // Delete FoodItem
    @GetMapping("/delete")
    public String deleteFood(@RequestParam Long id) {
        foodService.deleteFood(id);
        return "redirect:/food";
    }
}

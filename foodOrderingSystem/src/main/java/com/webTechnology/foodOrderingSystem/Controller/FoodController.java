package com.webTechnology.foodOrderingSystem.Controller;

import com.webTechnology.foodOrderingSystem.Service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FoodController {
    @Autowired
    private FoodService foodService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("foodItems", foodService.getAllFoodItems());
        return "index";
    }
}

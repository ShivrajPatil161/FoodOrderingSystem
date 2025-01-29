package com.webTechnology.foodOrderingSystem.Controller;

import com.webTechnology.foodOrderingSystem.Service.CategoryService;
import com.webTechnology.foodOrderingSystem.Service.FoodService;
import com.webTechnology.foodOrderingSystem.global.GlobalData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class HomeController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    FoodService foodService;

    @GetMapping({"/","/home"})
    public String home(Model model){
        model.addAttribute("cartCount", GlobalData.cart.size());
        return "index";
    }

    @GetMapping("/shop")
    public String shop(Model model){
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("food",foodService.getAllFoodItems());
        model.addAttribute("cartCount",GlobalData.cart.size());
        return "shop";
    }

    @GetMapping("/shop/category/{id}")
    public String shopByCategory(Model model,@PathVariable int id){
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("food",foodService.getAllFoodByCategoryId(id));
        model.addAttribute("cartCount",GlobalData.cart.size());
        return "shop";
    }
    @GetMapping("/shop/viewfood/{id}")
    public String viewFood(Model model,@PathVariable int id){
        model.addAttribute("food",foodService.getFoodById(id).get());
        model.addAttribute("cartCount",GlobalData.cart.size());
        return "viewFood";
    }



}
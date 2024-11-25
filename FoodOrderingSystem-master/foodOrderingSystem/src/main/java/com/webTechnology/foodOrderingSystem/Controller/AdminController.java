package com.webTechnology.foodOrderingSystem.Controller;


import com.webTechnology.foodOrderingSystem.Model.Category;
import com.webTechnology.foodOrderingSystem.Service.CategoryService;
import com.webTechnology.foodOrderingSystem.Service.FoodService;
import com.webTechnology.foodOrderingSystem.dto.FoodDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class AdminController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    FoodService foodService;

    @GetMapping("/admin")
    public String adminHome() {
        return "adminHome";
    }

    @GetMapping("admin/categories")
    public String getCat(Model model) {
        model.addAttribute("categories", categoryService.getAllCategories());
        return "categories";
    }

    @GetMapping("admin/categories/add")
    public String getCatAdd(Model model) {
        model.addAttribute("category", new Category());
        return "categoriesAdd";
    }

    @PostMapping("admin/categories/add")
    public String postCatAdd(@ModelAttribute("category") Category category) {
        categoryService.addCategory(category);
        return "redirect:/admin/categories";
    }
    @GetMapping("admin/categories/delete/{id}")
    public String deleteCat(@PathVariable int id) {
        categoryService.deleteCategoryById(id);
        return "redirect:/admin/categories";
    }
    @GetMapping("admin/categories/update/{id}")
    public String updateCat(@PathVariable int id, Model model) {
        Optional<Category> category = categoryService.getCategoryById(id);
        if (category.isPresent()) {
            model.addAttribute("category", category.get());
            return "categoriesAdd";
        }
        else
            return "404";
    }

    // Food Section
    @GetMapping("admin/food")
    public String Food(Model model) {
        model.addAttribute("food", foodService.getAllFoodItems());
        return "food";
    }

    @GetMapping("admin/food/add")
    public String FoodADDGet(Model model) {
        model.addAttribute("FoodDTO", new FoodDTO());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "foodAdd";
    }






}

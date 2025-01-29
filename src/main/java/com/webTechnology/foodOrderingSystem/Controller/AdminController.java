package com.webTechnology.foodOrderingSystem.Controller;


import com.webTechnology.foodOrderingSystem.Model.Category;
import com.webTechnology.foodOrderingSystem.Model.FoodItem;
import com.webTechnology.foodOrderingSystem.Service.CategoryService;
import com.webTechnology.foodOrderingSystem.Service.FoodService;
import com.webTechnology.foodOrderingSystem.dto.FoodDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.UUID;

@Controller
public class AdminController {
    public static String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/foodImages";
    @Autowired
    CategoryService categoryService;
    @Autowired
    FoodService foodService;

    @GetMapping("/admin")
    public String adminHome() {
        return "adminHome";
    }

    @GetMapping("/admin/categories")
    public String getCat(Model model) {
        model.addAttribute("categories", categoryService.getAllCategories());
        return "categories";
    }

    @GetMapping("/admin/categories/add")
    public String getCatAdd(Model model) {
        model.addAttribute("category", new Category());
        return "categoriesAdd";
    }

    @PostMapping("/admin/categories/add")
    public String postCatAdd(@ModelAttribute("category") Category category) {
        categoryService.addCategory(category);
        return "redirect:/admin/categories";
    }
    @GetMapping("/admin/categories/delete/{id}")
    public String deleteCat(@PathVariable int id) {
        categoryService.deleteCategoryById(id);
        return "redirect:/admin/categories";
    }
    @GetMapping("/admin/categories/update/{id}")
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
    @GetMapping("/admin/food")
    public String Food(Model model) {
        model.addAttribute("food", foodService.getAllFoodItems());
        return "food";
    }

    @GetMapping("/admin/food/add")
    public String FoodADDGet(Model model) {
        model.addAttribute("FoodDTO", new FoodDTO());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "foodAdd";
    }

    @PostMapping("/admin/food/add")
    public String foodAddPost(@ModelAttribute("FoodDTO") FoodDTO foodDTO,
                              @RequestParam("foodImage") MultipartFile file,
                              @RequestParam("imgName")String imgName)throws IOException
    {
        FoodItem food  = new FoodItem();
        food.setId(foodDTO.getId());
        food.setName(foodDTO.getName());
        food.setCategory(categoryService.getCategoryById(foodDTO.getCategoryId()).get());
        food.setPrice(foodDTO.getPrice());
        food.setQuantity(foodDTO.getQuantity());
        food.setDescription(foodDTO.getDescription());
        String imageUUID;
        if(!file.isEmpty())
        {
            imageUUID = file.getOriginalFilename();
            Path fileNameAndPath = Paths.get(uploadDir, imageUUID);
            Files.write(fileNameAndPath, file.getBytes());
        } else {
            imageUUID = imgName;
        }
        food.setImageName(imageUUID);
        foodService.addFood(food);
        return "redirect:/admin/food";
    }

    @GetMapping("/admin/food/delete/{id}")
    public String deletefood(@PathVariable long id) {
        foodService.removeFoodById(id);
        return "redirect:/admin/food";
        }


    @GetMapping("/admin/food/update/{id}")
    public String updatefoodGet(@PathVariable long id, Model model) {
        FoodItem foodItem = foodService.getFoodById(id).get();
        FoodDTO foodDTO = new FoodDTO();
        foodDTO.setId(foodItem.getId());
        foodDTO.setName(foodItem.getName());
        foodDTO.setCategoryId(foodItem.getCategory().getId());
        foodDTO.setPrice(foodItem.getPrice());
        foodDTO.setQuantity(foodItem.getQuantity());
        foodDTO.setDescription(foodItem.getDescription());
        foodDTO.setImageName(foodItem.getImageName());

        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("FoodDTO", foodDTO);
        return "foodAdd";

    }

}

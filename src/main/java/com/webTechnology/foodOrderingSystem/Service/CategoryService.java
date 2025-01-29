package com.webTechnology.foodOrderingSystem.Service;

import com.webTechnology.foodOrderingSystem.Model.Category;
import com.webTechnology.foodOrderingSystem.Repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepo categoryRepo;
    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }
    public void addCategory(Category category) {
        categoryRepo.save(category);
    }

    public Optional<Category> getCategoryById(int id) {
        return categoryRepo.findById(id);
    }
    public void deleteCategoryById(int id) {
        categoryRepo.deleteById(id);
    }

    public void updateCategoryById(int id, Model model) {
        categoryRepo.saveAndFlush(categoryRepo.getOne(id));
    }
}

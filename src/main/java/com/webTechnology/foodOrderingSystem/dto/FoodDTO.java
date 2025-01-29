package com.webTechnology.foodOrderingSystem.dto;

import com.webTechnology.foodOrderingSystem.Model.Category;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class FoodDTO {
    private Long id;
    private String name;
    private double price;
    private int categoryId;
    private int quantity;
    private String description;
    private String imageName;
}

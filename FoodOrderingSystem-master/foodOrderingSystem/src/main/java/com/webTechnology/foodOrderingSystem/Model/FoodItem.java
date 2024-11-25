package com.webTechnology.foodOrderingSystem.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class FoodItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;

    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private Category category;
    private int quantity;
    private String description;
    private String imageName;


}

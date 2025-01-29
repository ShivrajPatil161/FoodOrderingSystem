package com.webTechnology.foodOrderingSystem.global;

import com.webTechnology.foodOrderingSystem.Model.FoodItem;

import java.util.ArrayList;
import java.util.List;

public class GlobalData {
    public static List<FoodItem> cart;
    static {
        cart = new ArrayList<FoodItem>();
    }
}

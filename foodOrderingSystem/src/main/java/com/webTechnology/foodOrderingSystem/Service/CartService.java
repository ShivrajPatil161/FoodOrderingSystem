package com.webTechnology.foodOrderingSystem.Service;

import com.webTechnology.foodOrderingSystem.Model.Cart;
import com.webTechnology.foodOrderingSystem.Repo.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    private CartRepo cartRepository;

    public void addToCart(Cart cart) {
        cartRepository.save(cart);
    }

    public List<Cart> getCartItems() {
        return cartRepository.findAll();
    }

    public void clearCart() {
        cartRepository.deleteAll();
    }
}

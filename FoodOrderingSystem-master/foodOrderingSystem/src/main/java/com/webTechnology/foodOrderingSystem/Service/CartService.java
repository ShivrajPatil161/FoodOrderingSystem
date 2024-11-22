package com.webTechnology.foodOrderingSystem.Service;

import com.webTechnology.foodOrderingSystem.Model.Cart;
import com.webTechnology.foodOrderingSystem.Repo.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    @Autowired
    private CartRepo cartRepository;

    public Cart saveCart(Cart cart) {
        return cartRepository.save(cart);
    }



    public void addToCart(Cart cart) {
        cartRepository.save(cart);
    }

    public List<Cart> getAllCartItems() {
        return cartRepository.findAll();
    }

    public Optional<Cart> getCartById(Long id) {
        return cartRepository.findById(id);
    }

    public void deleteCart(Long id) {
        cartRepository.deleteById(id);
    }

    public void clearCart() {
        cartRepository.deleteAll();
    }
}

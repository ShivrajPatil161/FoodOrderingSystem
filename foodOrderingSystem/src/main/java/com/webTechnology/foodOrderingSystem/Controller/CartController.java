package com.webTechnology.foodOrderingSystem.Controller;


import com.webTechnology.foodOrderingSystem.Model.Cart;
import com.webTechnology.foodOrderingSystem.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;


@Controller
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping("/add-to-cart")
    public String addToCart(@RequestParam String foodName, @RequestParam double price) {
        Cart cart = new Cart();
        cart.setFoodName(foodName);
        cart.setPrice(price);
        cartService.addToCart(cart);
        return "redirect:/cart";
    }

    @GetMapping("/cart")
    public String viewCart(Model model) {
        model.addAttribute("cartItems", cartService.getCartItems());
        return "cart";
    }

    @PostMapping("/place-order")
    public String placeOrder() {
        cartService.clearCart();
        return "order";
    }
}

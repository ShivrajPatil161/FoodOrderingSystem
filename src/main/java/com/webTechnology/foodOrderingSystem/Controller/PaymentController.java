package com.webTechnology.foodOrderingSystem.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PaymentController {

    @PostMapping("/payNow")
    public String processPayment(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("successMessage", "Order placed successfully!");
        return "redirect:/shop";
    }
}


package edu.blakealmanza.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @GetMapping("/products")
    public String products(Model model) {
        model.addAttribute("role", "customer");
        model.addAttribute("content", "customer/products");
        return "index";
    }

    @GetMapping("/cart")
    public String cart(Model model) {
        model.addAttribute("role", "customer");
        model.addAttribute("content", "customer/cart");
        return "index";
    }

    @GetMapping("/checkout")
    public String checkout(Model model) {
        model.addAttribute("role", "customer");
        model.addAttribute("content", "customer/checkout");

        return "index";
    }

}

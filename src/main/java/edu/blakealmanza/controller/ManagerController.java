package edu.blakealmanza.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manager")
public class ManagerController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("name", "Blake");
        return "index";
    }

    @GetMapping("/products")
    public String showAllProducts(Model model) {
        return "manager/products";
    }
}

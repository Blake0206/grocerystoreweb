package edu.blakealmanza.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manager")
public class ManagerController {

    @GetMapping("/products")
    public String showAllProducts(Model model) {
        model.addAttribute("role", "manager");
        model.addAttribute("content", "manager/products");
        return "layout";
    }

    @GetMapping("/add-product")
    public String addProduct(Model model) {
        model.addAttribute("role", "manager");
        model.addAttribute("content", "manager/add-product");
        return "layout";
    }

    @GetMapping("/inventory-files")
    public String showFiles(Model model) {
        model.addAttribute("role", "manager");
        model.addAttribute("content", "manager/inventory-files");
        return "layout";
    }
}

package edu.blakealmanza.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("content", "index");
        return "layout"; // Uses layout.html with index.html as content
    }

    @GetMapping("/customer/home")
    public String customerHome(Model model) {
        model.addAttribute("role", "customer");
        model.addAttribute("content", "customer/home");
        return "layout"; // Layout template
    }

    @GetMapping("/manager/home")
    public String managerHome(Model model) {
        model.addAttribute("role", "manager");
        model.addAttribute("content", "manager/home");
        return "layout"; // Layout template
    }
}

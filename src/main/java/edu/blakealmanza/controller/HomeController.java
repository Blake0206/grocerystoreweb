package edu.blakealmanza.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String welcome(Model model) {
        model.addAttribute("content", "welcome");
        return "index"; // Uses index.html with welcome.html as content
    }

    @GetMapping("/customer/home")
    public String customerHome(Model model) {
        model.addAttribute("role", "customer");
        model.addAttribute("content", "customer/home");
        return "index"; // index template
    }

    @GetMapping("/manager/home")
    public String managerHome(Model model) {
        model.addAttribute("role", "manager");
        model.addAttribute("content", "manager/home");
        return "index"; // index template
    }
}

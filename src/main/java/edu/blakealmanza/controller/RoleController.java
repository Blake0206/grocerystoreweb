package edu.blakealmanza.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RoleController {

    @PostMapping("/roleSelection")
    public String handleRoleSelection(@RequestParam String role, Model model) {
        // Add the role to the model so it can be accessed in the navbar
        model.addAttribute("role", role);

        // Redirect to the corresponding home page
        if ("customer".equals(role)) {
            return "redirect:/customer/home";
        } else if ("manager".equals(role)) {
            return "redirect:/manager/home";
        }
        return "welcome"; // default to welcome page if no role selected
    }
}

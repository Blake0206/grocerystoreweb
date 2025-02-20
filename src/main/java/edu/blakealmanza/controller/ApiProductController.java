package edu.blakealmanza.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.blakealmanza.model.Product;
import edu.blakealmanza.service.ProductService;

@RestController
@RequestMapping("/api/v1")
public class ApiProductController {

    private final ProductService managerService;

    @Autowired
    public ApiProductController(ProductService managerService) {
        this.managerService = managerService;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return managerService.getAllProducts();
    }

}

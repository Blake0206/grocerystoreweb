package edu.blakealmanza.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.blakealmanza.services.ManagerService;
import edu.blakealmanza.services.ProductWithQuantity;

@RestController
@RequestMapping("/api/v1")
public class ApiController {

  private final ManagerService managerService;

  @Autowired
  public ApiController(ManagerService managerService) {
    this.managerService = managerService;
  }

  @GetMapping("/products")
  public List<ProductWithQuantity> getAllProducts() {
    return managerService.getAllProducts();
  }

}

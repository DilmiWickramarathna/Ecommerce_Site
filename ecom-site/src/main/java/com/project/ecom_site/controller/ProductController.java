package com.project.ecom_site.controller;

import com.project.ecom_site.model.Product;
import com.project.ecom_site.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin //Fix CORS errors
@RequestMapping("/ecomsite")
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        System.out.println("In Controller..........");
        return service.getAllProducts();
    }
}

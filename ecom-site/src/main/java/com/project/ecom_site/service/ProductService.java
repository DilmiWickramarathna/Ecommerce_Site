package com.project.ecom_site.service;

import com.project.ecom_site.model.Product;
import com.project.ecom_site.repository.ProductRepository;
import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
@ToString
public class ProductService {

    @Autowired
    private ProductRepository prodRepo;

    public List<Product> getAllProducts() {
        List<Product> products = prodRepo.findAll();
        System.out.println("Products from DB: " + products);
        return products;
    }
}

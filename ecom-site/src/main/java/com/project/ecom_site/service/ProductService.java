package com.project.ecom_site.service;

import com.project.ecom_site.model.Product;
import com.project.ecom_site.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.ToString;
import org.hibernate.StaleObjectStateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
@ToString
public class ProductService {

    @Autowired
    private ProductRepository prodRepo;

    public List<Product> getAllProducts() {
        return prodRepo.findAll();
    }

    public Product getProductById(int id) {
        return prodRepo.findById(id).orElse(null);
    }
    
    public void addNewProduct(Product product) {
        try {
            prodRepo.save(product);
        } catch (StaleObjectStateException e) {
            // Handle conflict, e.g., refresh the entity or retry
            System.out.println("Conflict detected: " + e.getMessage());
        }
    }
}

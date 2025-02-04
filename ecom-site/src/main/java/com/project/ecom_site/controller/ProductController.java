package com.project.ecom_site.controller;

import com.project.ecom_site.model.Product;
import com.project.ecom_site.service.ProductService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin //Fix CORS errors
@RequestMapping("/ecomsite")
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(service.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id){

        Product product = service.getProductById(id);

        if(product != null)
            return new ResponseEntity<>(product,HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/product")
    public void addProduct(@RequestBody Product product)
    {
        service.addNewProduct(product);
    }

    @PutMapping("/product")
    public ResponseEntity<String> updateProduct(@RequestBody Product product)
    {
        Product p = service.updateProduct(product);
        if(p != null)
        {
            return new ResponseEntity<>("Updated", HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping ("/product/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id)
    {
        Product p = service.getProductById(id);
        if(p != null)
        {
            service.deleteProduct(id);
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/products/search")
    public ResponseEntity<List<Product>> getProductsBySearch(@RequestParam String keyword)
    {
        List<Product> prodList = service.getProductListBySearch(keyword);
        return new ResponseEntity<>(prodList,HttpStatus.OK);
    }
}

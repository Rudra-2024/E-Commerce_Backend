package com.rudra.ecommerce_fakestore.Controller;

import com.rudra.ecommerce_fakestore.DTOs.RequestBodyProductDTO;
import com.rudra.ecommerce_fakestore.Service.Product_service;
import com.rudra.ecommerce_fakestore.models.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.rudra.ecommerce_fakestore.Service.FakestoreProductService;

import java.util.List;

@RestController
public class ProductController {

    Product_service productService;

    public ProductController(@Qualifier("fakestore") Product_service productService){
        this.productService=productService;
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody RequestBodyProductDTO request){
        return productService.createProduct(request.getTitle(),
                request.getDescription(),
                request.getPrice(),
                request.getCategory(),
                request.getImage());
    }

    @GetMapping("/products/{id}")
    public Product getProductDetails(@PathVariable("id") long id){
        return productService.getSingleProduct(id);
    }

    @GetMapping("/AllProducts")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.CONFLICT);

    }

    @PutMapping
    public void updateProduct(){

    }

}

package com.rudra.ecommerce_fakestore.Service;

import com.rudra.ecommerce_fakestore.models.Product;

import java.util.List;

public interface Product_service {

    Product getSingleProduct(long productId);

    List<Product> getAllProducts();

    Product createProduct(String title,
                          String description,
                          double price,
                          String category,
                          String image);
}


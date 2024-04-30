package com.rudra.ecommerce_fakestore.DTOs;

import com.rudra.ecommerce_fakestore.models.Category;
import com.rudra.ecommerce_fakestore.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class fakestoreDTO {

    private long id;
    private String title;
    private String image;
    private String description;
    private String category;
    private double price;

    public Product toProduct(){
        Product product = new Product();

        product.setId(id);
        product.setTitle(title);
        product.setPrice(price);
        product.setDescription(description);
        product.setImageURL(image);

        Category category1 = new Category();
        category1.setTitle(title);
        category1.setDescription(description);

        product.setCategory(category1);

        return product;
    }
}

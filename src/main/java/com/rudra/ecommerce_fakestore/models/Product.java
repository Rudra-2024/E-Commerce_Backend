package com.rudra.ecommerce_fakestore.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private long id;;
    private String title;
    private String description;
    private double price;
    private String imageURL;
    private Category category;

}

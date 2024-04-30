package com.rudra.ecommerce_fakestore.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestBodyProductDTO {
    private long id;
    private String title;
    private double price;
    private String description;
    private String image;
    private String category;
}

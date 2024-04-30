package com.rudra.ecommerce_fakestore.Service;

import com.rudra.ecommerce_fakestore.DTOs.fakestoreDTO;
import com.rudra.ecommerce_fakestore.models.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@Service("fakestore")
public class FakestoreProductService implements Product_service{

    private RestTemplate restTemplate;
    public FakestoreProductService(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }
    @Override
    public Product getSingleProduct(long productId) {
        if(productId==0){
            throw new IllegalArgumentException("Invalid Id, Please try some other Id");
        }
        ResponseEntity<fakestoreDTO> response = restTemplate.getForEntity(
                "https://fakestoreapi.com/products/" + productId,fakestoreDTO.class);
        return response.getBody().toProduct();
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products=new ArrayList<>();
        fakestoreDTO[] response = restTemplate.getForObject(
                "https://fakestoreapi.com/products",
                fakestoreDTO[].class);
        for(fakestoreDTO productDto : response){
            products.add(productDto.toProduct());
        }

        return products;
    }

    @Override
    public Product createProduct(String title,
                                 String description,
                                 double price,
                                 String category,
                                 String image) {
        fakestoreDTO sendDTO = new fakestoreDTO();
        sendDTO.setTitle(title);
        sendDTO.setDescription(description);
        sendDTO.setPrice(price);
        sendDTO.setCategory(category);
        sendDTO.setImage(image);
        fakestoreDTO fakestoreDTO1 = restTemplate.postForObject(
                "https://fakestoreapi.com/products",
                sendDTO,
                fakestoreDTO.class);
        return fakestoreDTO1.toProduct();
    }
}

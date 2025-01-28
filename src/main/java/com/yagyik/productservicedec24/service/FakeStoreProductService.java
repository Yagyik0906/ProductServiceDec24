package com.yagyik.productservicedec24.service;

import com.yagyik.productservicedec24.dtos.FakeStoreProductDto;
import com.yagyik.productservicedec24.models.Category;
import com.yagyik.productservicedec24.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{
    RestTemplate restTemplate;

    FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getProduct(Long productId) {
        FakeStoreProductDto fakeStoreProductDto=restTemplate.getForObject(
                "https://fakestoreapi.com/products/" + productId,
                FakeStoreProductDto.class
        );
       return convertFakeStoreProductToProduct(fakeStoreProductDto);

    }

    @Override
    public ArrayList<Product> getAllProduct() {

        FakeStoreProductDto[] fakeStoreProductDto=restTemplate.getForObject(
                "https://fakestoreapi.com/products",
                FakeStoreProductDto[].class);
        ArrayList<Product> products=new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto1:fakeStoreProductDto){
            products.add(convertFakeStoreProductToProduct(fakeStoreProductDto1));
        }
        return products;
    }

    @Override
    public String saveAllProduct(List<Product> products) {
        return "";
    }

    @Override
    public Product createProduct(Product product) {
        FakeStoreProductDto fakeStoreProductDto=restTemplate.postForObject(
                "https://fakestoreapi.com/products",
                product,
                FakeStoreProductDto.class);
        return product;
    }

    @Override
    public Product updateProduct(Product product) {

        return product;
    }

    @Override
    public String deleteProduct(Long productId) {

        return null;
    }

    @Override
    public Product replaceProduct(Product product) {

        return product;
    }

    public Product convertFakeStoreProductToProduct(FakeStoreProductDto fakeStoreProductDto) {
        Product product=new Product();
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImage(fakeStoreProductDto.getImage());
        Category category=new Category();
        category.setValue(fakeStoreProductDto.getCategory());
        product.setCategory(category);
        return product;
    }
}

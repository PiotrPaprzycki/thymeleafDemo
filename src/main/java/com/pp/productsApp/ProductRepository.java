package com.pp.productsApp;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> products;

    public ProductRepository() {
        products = new ArrayList<>();
        products.add(new Product("mleko", 25, "domowe"));
        products.add(new Product("patelnia", 100, "domowe"));
    }


    public List<Product> findByCategory(String category) {
        List<Product> products = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory().equals(category)) {
                products.add(product);
            }
        }
        return products;
    }
}

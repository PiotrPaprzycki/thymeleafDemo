package com.pp.productsApp;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> products;

    public ProductRepository() {
        products = new ArrayList<>();
        products.add(new Product("mleko", 10, "spozywcze"));
        products.add(new Product("chleb", 5, "spozywcze"));
        products.add(new Product("patelnia", 100, "domowe"));
        products.add(new Product("garnek", 125, "domowe"));
    }


    public List<Product> findByCategory(String category) {
        List<Product> filteredProductsArrayList = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory().equals(category)) {
                filteredProductsArrayList.add(product);
            }
        }
        return filteredProductsArrayList;
    }

    public List<Product> getAll() {
        return products;
    }
}

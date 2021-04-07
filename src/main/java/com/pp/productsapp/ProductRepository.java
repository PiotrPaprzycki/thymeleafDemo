package com.pp.productsapp;

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

    public int getPrice(String category) {
        int price = 0;
        if (category != null) {
            for (Product product : products) {
                if (product.getCategory().equals(category)) {
                    price += product.getPrice();
                }
            }
            return price;
        } else {
            for (Product product : products) {
                price += product.getPrice();
            }
            return price;
        }
    }

    public void addProduct(Product product) {
        products.add(product);
    }
}

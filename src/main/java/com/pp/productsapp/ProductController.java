package com.pp.productsapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {

    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("product", new Product());
        return "index";
    }

    @GetMapping("/list")
    public Object list(@RequestParam(required = false) String category, Model model) {

        if (category == null || category.equals("")) {
            int sumPrice = 0;
            List<Product> productList = productRepository.getAll();
            sumPrice = productRepository.getPrice(category);
            model.addAttribute("productList", productList);
            model.addAttribute("price", sumPrice);
            return "productList";
        }

        List<Product> productList = productRepository.findByCategory(category);

        if (!productList.isEmpty()) {
            int sumPrice = 0;
            model.addAttribute("productList", productList);
            sumPrice = productRepository.getPrice(category);
            model.addAttribute("price", sumPrice);
            return "productList";
        } else {
            return "redirect:error";
        }
    }

    @PostMapping("/add")
    public String add(Product product) {
        productRepository.addProduct(product);
        return "redirect:index";
    }
}

package com.pp.productsApp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {

    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/list")
    public Object list(@RequestParam(required = false) String category, Model model) {

        if (category == null || category.equals("")) {
            List<Product> productList = productRepository.getAll();
            model.addAttribute("productList", productList);
            return "productList";
        }

        List<Product> productList = productRepository.findByCategory(category);

        if (!productList.isEmpty()) {
            model.addAttribute("productList", productList);
            return "productList";
        } else {
            return "redirect:error";
        }
    }
}

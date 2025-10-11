package com.poly.lab2.controller;

import com.poly.lab2.entity.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {
    private List<Product> items = new ArrayList<>();
    private Product lastSavedProduct;
    public ProductController() {
        items.add(new Product("A", 1.0));
        items.add(new Product("B", 12.0));
    }

    @GetMapping("/product/form")
    public String form(Model model) {
        Product p = new Product("iPhone 30", 5000.0);
        model.addAttribute("p", p);
        model.addAttribute("product", new Product());
        model.addAttribute("items", items);
        model.addAttribute("lastSavedProduct", lastSavedProduct);

        return "product_form";
    }

    // Lưu sản phẩm khi submit for
    @PostMapping("/product/save")
    public String save(Model model, @ModelAttribute("product") Product p) {
        items.add(p);
        lastSavedProduct = p;
        model.addAttribute("p", new Product("iPhone 30", 5000.0));
        model.addAttribute("product", new Product());
        model.addAttribute("items", items);
        model.addAttribute("lastSavedProduct", lastSavedProduct);

        return "product_form";
    }
}

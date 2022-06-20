package com.product.controller;

import com.product.model.Product;
import com.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String showProductList(Model model) {
        List<Product> productList = productService.findAll();
        model.addAttribute("productList", productList);
        return "product-list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id, Model model) {
        productService.delete(id);
        List<Product> productList = productService.findAll();
        model.addAttribute("productList", productList);
        return "product-list";
    }

    @PostMapping("/search")
    public String search(@RequestParam("name") String name, Model model){
        List<Product> productList = productService.searchByName(name);
        model.addAttribute("productList", productList);
        return "product-list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model){
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("product") Product product, Model model){
        productService.save(product);
        List<Product> productList = productService.findAll();
        model.addAttribute("productList", productList);
        return "product-list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") String id, Model model){
        Product product = productService.findById(id);
//        model.addAttribute("productValue", product);
        model.addAttribute("product", product);
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("product") Product product, Model model){
        productService.edit(product);
        List<Product> productList = productService.findAll();
        model.addAttribute("productList", productList);
        return "product-list";
    }
}

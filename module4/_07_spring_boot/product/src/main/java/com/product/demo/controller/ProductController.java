package com.product.demo.controller;

import com.product.demo.model.Product;
import com.product.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String showProductList(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Page<Product> productList = productService.findAll(PageRequest.of(page, 3));
        model.addAttribute("productList", productList);
        return "product-list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id, Model model) {
        productService.delete(id);
        return "redirect:/";
    }

    @PostMapping("/search")
    public String search(@RequestParam("name") String name, @RequestParam(name = "page", defaultValue = "0") int page, Model model){
        Page<Product> productList = productService.searchByName(name, PageRequest.of(page, 2));
        model.addAttribute("productList", productList);
        return "product-list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model){
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "create";
        }
        productService.save(product);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") String id, Model model){
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "create";
        }
        productService.edit(product);
        return "redirect:/";
    }
}

package com.example.PRODUCT.controller;

import com.example.PRODUCT.model.Product;
import com.example.PRODUCT.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.Optional;
@Controller
public class ProductController {
    private ProductService productser;

    public ProductController(ProductService productser) {
        this.productser = productser;
    }
    @GetMapping("/")
    public  String open (Model mod)
    {
        mod.addAttribute("productobj",new Product());
        return "index";
    }
    @PostMapping("/new")
    public  String create (@ModelAttribute("productobj")Product pro,Model mod)
    {
        productser.create(pro);
        mod.addAttribute("products",productser.getAllproducts());
        return "success";
    }
    @GetMapping("/del/{id}")
    public  String delete (@PathVariable("id")Long id,Model mod)
    {
        productser.deleteById(id);
        mod.addAttribute("products",productser.Read());
        return "success";
    }
    @GetMapping("/edit/{id}")
    public  String edit(@PathVariable Long id,Model mod)
    {
        mod.addAttribute("products",productser.getById(id).get());
        return "edit";
    }
    @PostMapping("/update/{id}")
    public  String update (@PathVariable Long id, @ModelAttribute Product product, Model mod)
    {
        productser.create(product);
        mod.addAttribute("products",productser.Read());
        return "success";
    }
}

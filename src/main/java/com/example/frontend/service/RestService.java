package com.example.frontend.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Controller
@Service
public class RestService {

    private final RestTemplate restTemplate;

    public RestService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public Product[] getPostsPlainJSON() {
        String url = "http://localhost:8080/recipe/all";
        return this.restTemplate.getForObject(url, Product[].class);
    }

    @RequestMapping("/products")
    public String demo(Model model){
        Product[] p = getPostsPlainJSON();
        model.addAttribute("Products", p);
        model.addAttribute("Productlist", "all products");
        return "product";
    }
}
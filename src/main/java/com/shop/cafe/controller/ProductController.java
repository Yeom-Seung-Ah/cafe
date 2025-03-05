package com.shop.cafe.controller;

import org.springframework.web.bind.annotation.RestController;

import com.shop.cafe.dto.Product;
import com.shop.cafe.service.ProductService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@CrossOrigin("http://192.168.0.11:5500")
public class ProductController {
   
   @Autowired //DI 의존성 주입 new 해주는 것 
   ProductService productService;
   
   @GetMapping("getAllProducts")
   public List<Product> getAllProducts() {
      try {
         System.out.println("getProducts");
         return productService.getAllProducts();
      } catch (Exception e) {
         e.printStackTrace();
         return null;
      }
   }
   
}

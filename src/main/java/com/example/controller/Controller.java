/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.controller;

import com.example.entities.Product;
import com.example.services.IProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Nicolás
 */

@RestController
public class Controller {  
    @Autowired
    private IProductService productService;
    
    @GetMapping(value = "/")
    public String example(){
        return "Hello World!";
    }
    
    @GetMapping(value = "/get")
    public List<Product> Get(){
        return this.productService.Get();
    }
    
    @PostMapping(value = "/add")
    public String Add(@RequestBody Product product){
        return this.productService.Add(product);
    }
    
    @PutMapping(value = "/edit/{id}")
    public String Edit(@PathVariable int id, @RequestBody Product product){
        return this.productService.Edit(id, product);
    } 
    
    @DeleteMapping(value = "/delete/{id}")
    public String Delete(@PathVariable int id){
         return this.productService.Delete(id);
    }
    
}

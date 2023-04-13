/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.services;

import com.example.entities.Product;
import java.util.List;
import com.example.repositories.IProductRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nicolás
 */
@Service
public class ProductService implements IProductService {
    
    private IProductRepository repository;

    public ProductService(IProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> Get() {
        return this.repository.findAll();
    }

    @Override
    public String Add(Product product) {
        this.repository.save(product);
        return "Added";
    }

    @Override
    public String Edit(int id, Product product) {
        Optional<Product> auxiliaryProduct = this.repository.findById(id);
        if(!auxiliaryProduct.isPresent()){
            return "Not found";
        }
        Product updateProduct = this.repository.findById(id).get();
        updateProduct.setName(product.getName());
        updateProduct.setPrice(product.getPrice());
        this.repository.save(updateProduct);
        return "Updated";
    }

    @Override
    public String Delete(int id) {
        Optional<Product> auxiliaryProduct = this.repository.findById(id);
        if(!auxiliaryProduct.isPresent()){
            return "Not found";
        }
        this.repository.deleteById(id);
        return "Deleted";
    }
    
    
}

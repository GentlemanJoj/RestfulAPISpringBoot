/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.services;

import com.example.entities.Product;
import java.util.List;

/**
 *
 * @author Nicolás
 */

public interface IProductService {

    String Add(Product product);

    String Edit(int id, Product product);

    String Delete(int id);

    List<Product> Get();
}

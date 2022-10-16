package com.irisaco.shop.modules.service;

import com.irisaco.shop.modules.model.Products;
import com.irisaco.shop.modules.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {
    private ProductsRepository productsRepository;

    @Autowired
    public ProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public List<Products> getAllProducts(){
        return this.productsRepository.findAll();
    }

    @Transactional
    public Integer addProduct(Products products){
        return  this.productsRepository.save(products).getId();
    }

    public Products getProduct(Integer id){
        Optional<Products> products=this.productsRepository.findById(id);
        if(products.isPresent())
            return  products.get();
        else
            return new Products();
    }

    @Transactional
    public void deleteProduct(Integer id){
        productsRepository.deleteById(id);
    }
}

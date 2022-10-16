package com.irisaco.shop.modules.controller;

import ch.qos.logback.classic.spi.EventArgUtil;
import com.irisaco.shop.modules.model.Products;
import com.irisaco.shop.modules.service.ProductsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
    private ProductsService productsService;

    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @RequestMapping(value = {"/",""},method = RequestMethod.GET)
    public List<Products> getAllProducts() {
        return productsService.getAllProducts();
    }

    @RequestMapping(value = {"/",""},method = RequestMethod.POST)
    public Integer addProduct(@RequestBody Products products){
        return productsService.addProduct(products);
    }

    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public Products getProduct(@PathVariable("id") Integer id){
        return productsService.getProduct(id);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Integer editProduct(@RequestBody Products products,@PathVariable("id") Integer id)
    {
        Products currentProduct= productsService.getProduct(id);
        if(currentProduct.getId()==null)
            return 404;
        else {
            productsService.addProduct(products);
            return 200;
        }
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public Integer deleteProduct(@PathVariable("id") Integer id){
        Products currentProduct= productsService.getProduct(id);
        if(currentProduct.getId()==null)
            return 404;
        else {
            productsService.deleteProduct(id);
            return 200;
        }
    }
}

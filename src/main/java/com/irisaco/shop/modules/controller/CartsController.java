package com.irisaco.shop.modules.controller;

import com.irisaco.shop.modules.model.Carts;
import com.irisaco.shop.modules.model.Products;
import com.irisaco.shop.modules.service.CartsService;
import com.irisaco.shop.modules.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api/carts")
public class CartsController {
    private CartsService cartsService;
    private ProductsService productsService;

    @Autowired
    public CartsController(CartsService cartsService,ProductsService productsService) {
        this.cartsService = cartsService;
        this.productsService=productsService;
    }

    @RequestMapping(value={"/",""},method = RequestMethod.GET)
    public List<Carts> getAllCarts(){
        return cartsService.getAllCarts();
    }

    @Transactional
    @RequestMapping(value = {"/",""},method = RequestMethod.POST)
    public Integer addCart(@RequestBody Carts carts){
        String[] ids= carts.getProduct_id().split(",");
        String[] quantities=carts.getQuantity().split(",");
        for(Integer i=0;i<ids.length;i++){
            int id2=Integer.parseInt(ids[i]);
            Products products= productsService.getProduct(id2);
            if(products.getId()!=null) {
                Integer availableQuantity= products.getQuantity();
                Integer quantity= Integer.parseInt(quantities[i]);
                availableQuantity=availableQuantity-quantity;
                if(availableQuantity<0)
                    return -1;
                products.setQuantity(availableQuantity);
                productsService.addProduct(products);
            }
        }
        return  cartsService.addCarts(carts);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Carts getCart(@PathVariable("id") Integer id){
        return cartsService.getCart(id);
    }

    @Transactional
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public Integer deleteCart(@PathVariable("id") Integer id){
        Carts carts= cartsService.getCart(id);
        if(carts.getId()==null)
            return  404;
        else {
            cartsService.deleteCart(id);
            return 200;
        }
    }
}

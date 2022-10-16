package com.irisaco.shop.modules.service;

import com.irisaco.shop.modules.model.Carts;
import com.irisaco.shop.modules.repository.CartsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartsService {
    private CartsRepository cartsRepository;

    @Autowired
    public CartsService(CartsRepository cartsRepository) {
        this.cartsRepository = cartsRepository;
    }

    public List<Carts> getAllCarts(){
        return this.cartsRepository.findAll();
    }

    public Integer addCarts(Carts carts){
        return this.cartsRepository.save(carts).getId();
    }

    public Carts getCart(Integer id){
        Optional<Carts> carts=cartsRepository.findById(id);
        if(carts.isPresent())
            return carts.get();
        else
            return new Carts();
    }

    public void deleteCart(Integer id){
        cartsRepository.deleteById(id);
    }
}
